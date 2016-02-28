package xyz.hanks.combination;

import rx.Observable;
import rx.functions.Func1;

import java.util.Random;

/**
 * Created by hanks on 16/2/23.
 */
public class Merge {
    public static void main(String[] args) {
        /*Observable<Integer> observable1 = Observable.just(1, 3, 5, 7, 9);
        Observable<Integer> observable2 = Observable.just(2, 4, 6, 8);
        Observable<String> observable3 = Observable.just("a", "b", "c");

        Observable.merge(observable1,observable2,observable3)
                .subscribe(s-> System.out.println("s = " + s));
        */

        Observable<Integer> observable1 = Observable.just(1, 3, 5, 7, 9).map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                try {
                    System.out.println("integer1 = " + integer);
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return integer;
            }
        });
        Observable<Integer> observable2 = Observable.just(2, 4, 6, 8).map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                try {
                    System.out.println("integer2 = " + integer);
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return integer;
            }
        });
        Observable<String> observable3 = Observable.just("a", "b", "c");

        Observable.merge(observable2,observable1,observable3)
                .subscribe(s-> System.out.println("s = " + s));

    }
}
