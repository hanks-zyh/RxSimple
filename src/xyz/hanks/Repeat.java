package xyz.hanks;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by hanks on 16/1/27.
 */
public class Repeat {
    public static void main(String[] args) {
        Observable.just("hanks").repeat(6).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("s = " + s);
            }
        });

        Observable.just("*","#","$").repeat(3).subscribe(s -> System.out.println("s = " + s));

        Observable.just(5,6,7).repeatWhen(new Func1<Observable<? extends Void>, Observable<?>>() {
            @Override
            public Observable<?> call(Observable<? extends Void> observable) {
                return observable.take(2);
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("integer = " + integer);
            }
        });

    }
}
