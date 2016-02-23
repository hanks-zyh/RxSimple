package xyz.hanks.combination;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by hanks on 16/2/23.
 */
public class Zip {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5, 6, 7);
        Observable<String> observable2 = Observable.just("a", "b", "c", "d");


        observable1.zipWith(observable2, new Func2<Integer, String, Object>() {
            @Override
            public Object call(Integer integer, String s) {
                return integer + ":" + s;
            }
        }).subscribe(s -> System.out.println("s = " + s));

    }
}
