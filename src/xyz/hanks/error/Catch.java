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


        /*Observable.just("file1", "file2","file3")
                .doOnNext(fileName->{
                    try {
                        new FileInputStream(fileName);
                    } catch (FileNotFoundException e) {
                        //e.printStackTrace();
                    }
                })
                .subscribe(filename -> System.out.println("filename = " + filename),
                        throwable -> System.out.println("throwable = " + throwable));
*/
        Observable.just(1,2,3)
                .filter(o -> {
				    return o != null;
				})
                .map(new Func1<Integer, String>() {

					@Override
					public String call(Integer arg0) {
						
						String res = null;
						
						try {
							res =  100/(arg0-1) + "";	
						} catch (Exception e) {
							throw Exceptions.propagate(e);
						}
						return res;
					}
				})
                .subscribe(s-> System.out.println("s = " + s));
    }
}