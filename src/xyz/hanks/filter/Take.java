package xyz.hanks.filter;

import rx.Observable;

/**
 * Created by hanks on 16/2/19.
 */
public class Take {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .take(3)
                .subscribe(s-> System.out.println("s = " + s));
    }
}
