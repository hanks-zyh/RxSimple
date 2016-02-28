package xyz.hanks.combination;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by hanks on 16/2/28.
 */
public class Switch {
    public static void main(String[] args) {
        //flatMap操作符的运行结果
        Observable.just(10, 20, 30).flatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                //10的延迟执行时间为200毫秒、20和30的延迟执行时间为180毫秒
                int delay = 200;
                if (integer > 10)
                    delay = 180;

                return Observable.from(new Integer[]{integer, integer / 2}).delay(delay, TimeUnit.MILLISECONDS);
            }
        }).observeOn(Schedulers.newThread()).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("flatMap Next:" + integer);
            }
        });

        //concatMap操作符的运行结果
        Observable.just(10, 20, 30).concatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                //10的延迟执行时间为200毫秒、20和30的延迟执行时间为180毫秒
                int delay = 200;
                if (integer > 10)
                    delay = 180;

                return Observable.from(new Integer[]{integer, integer / 2}).delay(delay, TimeUnit.MILLISECONDS);
            }
        }).observeOn(Schedulers.newThread()).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("concatMap Next:" + integer);
            }
        });

        //switchMap操作符的运行结果
        Observable.just(10, 20, 30,59).switchMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                //10的延迟执行时间为200毫秒、20和30的延迟执行时间为180毫秒
                int delay = 200;
                if (integer > 20)
                    delay = 100;


                return Observable.from(new Integer[]{integer, integer / 2}).delay(delay, TimeUnit.MILLISECONDS);
            }
        }).observeOn(Schedulers.newThread()).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("switchMap Next:" + integer);
            }
        });


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
