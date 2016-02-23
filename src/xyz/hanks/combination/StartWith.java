package xyz.hanks.combination;

import rx.Observable;

/**
 * Created by hanks on 16/2/23.
 */
public class StartWith {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .startWith(100)
                .startWith(12)
                .subscribe(s-> System.out.println("s = " + s));
    }
}
