package xyz.hanks.test;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class TestSubscriber {
	public static void main(String[] args) {
		Observable.just(1,3,4)
		.map(new Func1<Integer, String>() {

			@Override
			public String call(Integer arg0) {
				String s = null;
				s.equals("");
				
				return null;
			}
		})
		.subscribe(new Action1<String>() {

			@Override
			public void call(String arg0) {
				System.out.println(arg0);
			}
		},new Action1<Throwable>() {

			@Override
			public void call(Throwable arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0);
			}
		});
		
		// must implement onError (Action1<Throwable> )
	}

}
