package xyz.hanks.filter;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hanks on 16/2/19.
 */
public class First {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7).first().subscribe(s -> System.out.println("s = " + s));

        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .first(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 2; // first true item
                    }
                })
                .subscribe(s -> System.out.println("s2 = " + s));

        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .firstOrDefault(1000, new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 10;
                    }
                })
                .subscribe(s -> System.out.println("s3= " + s));

        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .takeFirst(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 5;
                    }
                })
                .subscribe(s -> System.out.println("s4= " + s));


    }
}
