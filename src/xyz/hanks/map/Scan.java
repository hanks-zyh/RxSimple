package xyz.hanks.map;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by hanks on 16/1/30.
 */
public class Scan {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer sum, Integer item) {
                        return sum + item;
                    }
                })
                .subscribe(v -> System.out.println("v = " + v));
    }
}
