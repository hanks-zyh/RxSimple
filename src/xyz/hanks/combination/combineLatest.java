package xyz.hanks.combination;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

import java.util.Random;

/**
 * Created by hanks on 16/3/3.
 */
public class combineLatest {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5)
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        int millis = new Random().nextInt(1000);
                        System.out.println(integer + "sleep, millis = " + millis);
                        try {
                            Thread.sleep(millis);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return integer;
                    }
                });
        Observable<String> observable2 = Observable.just("A", "b", "c", "d")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String integer) {
                        int millis = new Random().nextInt(1000);
                        System.out.println("string : " + integer + ",sleep:" + millis);
                        try {
                            Thread.sleep(millis);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return integer;
                    }
                });


        Observable.combineLatest(observable1, observable2, new Func2<Integer, String, String>() {
            @Override
            public String call(Integer integer, String s) {
                return integer + "**" + s;
            }
        }).subscribe(s -> System.out.println("s = " + s));

        Observable.combineLatest(observable2, observable1, new Func2<String, Integer, String>() {
            @Override
            public String call(String s,Integer integer)  {
                return integer + "*_*" + s;
            }
        }).subscribe(s -> System.out.println("s2 = " + s));

    }
}


