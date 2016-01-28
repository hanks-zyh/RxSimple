package xyz.hanks.map;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hanks on 16/1/28.
 */
public class Buffer {
    public static void main(String[] args) {
        Observable.just(1,3,5,7,9,"a","b","c")
                .buffer(3,1)
        .subscribe(serializables -> System.out.println("serializables = " + serializables));


    }
}
