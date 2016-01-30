package xyz.hanks.filter;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by hanks on 16/1/30.
 */
public class Debounce {
    public static void main(String[] args) throws InterruptedException {
        String[] strs = new String[]{"a","b","c","d","e"};
        Observable.from(strs)
                .map(s1 -> {
                    System.out.println("s1 = " + s1);
                    try {

                        Thread.sleep(2000+new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s1;
                })
                .debounce(2200,TimeUnit.MILLISECONDS, Schedulers.newThread())
                .subscribe(s-> System.out.println("s = " + s));
        Thread.sleep(5000);
    }
}
