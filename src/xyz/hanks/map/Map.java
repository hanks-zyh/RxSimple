package xyz.hanks.map;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hanks on 16/1/28.
 */
public class Map {
    public static void main(String[] args) {
        Observable.just("best").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.length();
            }
        }).subscribe(s-> System.out.println("s = " + s));
    }
}
