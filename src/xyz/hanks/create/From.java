package xyz.hanks.create;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by hanks on 16/1/27.
 */
public class From {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Observable.from(nums).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("print:" + integer);
            }
        });
    }
}
