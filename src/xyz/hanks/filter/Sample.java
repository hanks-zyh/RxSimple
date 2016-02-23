package xyz.hanks.filter;

import rx.Observable;
import rx.functions.Func1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by hanks on 16/2/23.
 */
public class Sample {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        try {
                            int sleep = new Random().nextInt(2000);
                            System.out.println(integer + ",sleep = " + sleep);
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return integer;
                    }
                })
                .sample(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println("s = " + s));
    }
}
