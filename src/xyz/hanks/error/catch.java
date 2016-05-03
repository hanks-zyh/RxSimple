package xyz.hanks.error;


import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Catch {

    public static void main(String[] args) {


        Observable.just("file1", "file2","file3")
                .doOnNext(fileName->{
                    try {
                        new FileInputStream(fileName);
                    } catch (FileNotFoundException e) {
                        //e.printStackTrace();
                    }
                })
                .subscribe(filename -> System.out.println("filename = " + filename),
                        throwable -> System.out.println("throwable = " + throwable));




        int i = 0;

        Observable.just(null)
                .filter(new Func1<Object, Boolean>() {
                    @Override
                    public Boolean call(Object o) {
                        i = 1;
                        return o == null;
                    }
                })
                .subscribe(s-> System.out.println("s = " + s));
    }
}