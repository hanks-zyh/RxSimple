package xyz.hanks.map;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
        
        
        
        Observable.just(0)
        .subscribeOn(Schedulers.newThread())
        .map(new Func1<Integer, String>() {
			@Override
			public String call(Integer arg0) {
				try {
					return getStr(arg0);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
        	
		})
        .observeOn(Schedulers.io())
        .doOnNext(s->System.out.println("doOnNext:"+s))
        .subscribe();
        
    }
    
    
    public static String getStr(int t) throws Exception{
    	return null;
    }
}
