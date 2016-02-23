package xyz.hanks.combination;

import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;

/**
 * Created by hanks on 16/2/23.
 */
public class Zip {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5, 6, 7);
        Observable<String> observable2 = Observable.just("a", "b", "c", "d");
        Observable<Double> observable3 = Observable.just(1.0, 2.0, 3.0, 4.0, 5.0);

        observable1.zipWith(observable2, new Func2<Integer, String, Object>() {
            @Override
            public Object call(Integer integer, String s) {
                return integer + ":" + s;
            }
        }).subscribe(s -> System.out.println("s = " + s));


        Observable.zip(observable1, observable2, new Func2<Integer, String, String>() {
            @Override
            public String call(Integer integer, String s) {
                return integer+"--->"+s;
            }
        }).subscribe(v-> System.out.println("v = " + v));


        Observable.zip(observable1, observable2, observable3, new Func3<Integer, String, Double, Object>() {
            @Override
            public Object call(Integer integer, String s, Double aDouble) {
                return integer+","+s+","+aDouble;
            }
        }).subscribe(res-> System.out.println("res = " + res));
    }
}
