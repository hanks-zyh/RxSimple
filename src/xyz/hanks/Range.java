package xyz.hanks;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hanks on 16/1/27.
 */
public class Range {
    public static void main(String[] args) {
        Observable.range(1, 5, Schedulers.newThread()).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(Thread.currentThread().getName() + ":" + integer);
            }
        });
    }
}
