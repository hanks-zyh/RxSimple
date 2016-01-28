package xyz.hanks.map;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hanks on 16/1/28.
 */
public class FlatMap {
    public static void main(String[] args) {
        Observable.just(2016)
                .flatMap(new Func1<Integer, Observable<String>>() {
                    @Override
                    public Observable<String> call(Integer integer) {
                        return Observable.just(integer + "年");
                    }
                })
                .subscribe(value -> System.out.println("value = " + value));
    }
}
