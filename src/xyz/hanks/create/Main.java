package xyz.hanks.create;

import rx.Observable;
import rx.Subscriber;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        for (int i = 0; i < 5; i++) {
                            subscriber.onNext(i);
                        }
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError" + throwable.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer.toString());
            }
        });
        Set<String> set = new HashSet<>();
        set.add("string1");
        set.add("string2");
        set.add("string1");
        for (String s : set) {
            System.out.println("set i = " + s);
        }
        System.out.println(set.contains("string1"));
    }
}
