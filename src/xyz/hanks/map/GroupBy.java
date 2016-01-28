package xyz.hanks.map;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * Created by hanks on 16/1/28.
 */
public class GroupBy {
    public static void main(String[] args) {
        Observable.from(new String[]{"dddd", "a", "ccc", "bb"})
                .groupBy(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String v) {
                        System.out.println("v = " + v);
                        return v.length() > 2;
                    }
                })
                .flatMap(new Func1<GroupedObservable<Boolean, String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(GroupedObservable<Boolean, String> booleanStringGroupedObservable) {
                        return booleanStringGroupedObservable.getKey() ? Observable.just("length>2:") : Observable.just("length<=2");
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("s = " + s);
                    }
                });


        System.out.println("--------------");

        Observable.just(0, 1, 2, 3, 4, 5).groupBy(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer % 2 == 0;
            }
        }).flatMap(new Func1<GroupedObservable<Boolean, Integer>, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(GroupedObservable<Boolean, Integer> groupedObservable) {

                return groupedObservable.getKey() ? groupedObservable.take(1) : groupedObservable.take(0);//take(0) 丢弃
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer i) {
                System.out.println(i);
            }
        });
    }
}
