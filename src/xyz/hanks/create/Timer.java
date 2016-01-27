package xyz.hanks.create;

import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hanks on 16/1/27.
 */
public class Timer {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Observable
                .timer(5, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println("trigger = " + (System.currentTimeMillis()-startTime)),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onCompleted"));
        try {
            Thread.sleep(8*1000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
