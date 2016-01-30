package xyz.hanks.map;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by hanks on 16/1/30.
 */
public class Window {
    public static void main(String[] args) {
        Observable.just("a","b","c","d","e","f")
                .window(2,2)
                .subscribe(new Action1<Observable<String>>() {
                    @Override
                    public void call(Observable<String> stringObservable) {
                        System.out.println("stringObservable = " + stringObservable);
                        stringObservable.subscribe(s -> System.out.println("s = " + s));
                    }
                });
    }
}
