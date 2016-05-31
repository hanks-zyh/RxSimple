package xyz.hanks.filter;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hanks on 16/2/19.
 */
public class Filter {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer % 2 ==0; // return false will be abort
                    }
                })
                .subscribe(s-> System.out.println("s = " + s));
        
        Observable.just(1, 2, 3, 4, 5)
        .filter(s->s>10)
        .subscribe(i->System.out.println("i:"+i));
        
    }
}
