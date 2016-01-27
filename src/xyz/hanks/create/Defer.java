package xyz.hanks.create;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by hanks on 16/1/26.
 */
public class Defer {
    public static void main(String[] args) {
        User user = new User();
        user.setName("hanks");
        user.getName().map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return "UserName:"+s;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }
}


class User{
    private  String name;

    public void setName(String name) {
        this.name = name;
    }

    public Observable<String> getName(){
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(name);
            }
        });
    }
}