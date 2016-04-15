package xyz.hanks.error;


import rx.Observable;
import rx.exceptions.Exceptions;

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
    }
}