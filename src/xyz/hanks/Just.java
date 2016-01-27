package xyz.hanks;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import java.io.Serializable;

/**
 * Created by hanks on 16/1/27.
 */
public class Just {
    public static void main(String[] args) {
        Observable.just("one").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });

        Observable.just("one",2,3.0).subscribe(new Subscriber<Serializable>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println(throwable.getMessage());
            }

            @Override
            public void onNext(Serializable serializable) {
                System.out.println(serializable.toString());
            }
        });

    }
}
