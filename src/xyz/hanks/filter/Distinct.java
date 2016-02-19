package xyz.hanks.filter;

import rx.Observable;

/**
 * Created by hanks on 16/2/20.
 */
public class Distinct {
    public static void main(String[] args) {
        Observable.just(2, 5, 8, 3, 2, 5, 5, 7)
                .distinct()
                .subscribe(s -> System.out.println("s = " + s));
        Observable.just("one", "two", "three", "one", "one", "three", "four")
                .distinct()
                .subscribe(s -> System.out.println("s2 = " + s));
        Observable.just("one", "two", "three", "one", "one", "three", "four")
                .distinctUntilChanged()
                .subscribe(s -> System.out.println("s3 = " + s));
    }
}
