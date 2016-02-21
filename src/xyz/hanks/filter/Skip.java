package xyz.hanks.filter;

import rx.Observable;
import rx.functions.Func1;

import java.util.concurrent.TimeUnit;

/**
 * Created by hanks on 16/2/21.
 */
public class Skip {
    public static void main(String[] args) {

        Observable.just(1, 2, 3, 4, 5)
                .skip(3)
                .subscribe(s -> System.out.println("s = " + s));


        Observable.just(1, 2, 3, 4, 5)
                .skipLast(2)
                .subscribe(s -> System.out.println("s1 = " + s));




        //
        Observable<Long> observable2 = Observable.timer(2500, TimeUnit.MILLISECONDS);
        observable2.subscribe(v-> System.out.println("observable2 is called , v = " + v));

        Observable
                .just(1, 2, 3, 4, 5)
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return integer;
                    }
                })
                .skipUntil(observable2)
                .subscribe(s -> System.out.println("s2 = " + s));

    }
}
