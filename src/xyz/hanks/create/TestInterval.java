package xyz.hanks.create;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class TestInterval {
	public static void main(String[] args) {
		try { 
			System.out.println(Thread.currentThread());
			Subscriber subscriber = new Subscriber<Long>() {
				@Override
				public void onCompleted() {
					System.out.println("onCompleted");
				}

				@Override
				public void onError(Throwable throwable) {
					System.out.println("throwable");
				}

				@Override
				public void onNext(Long o) {
					System.out.println(Thread.currentThread() + "======3");
					System.out.println("Interval" + o);

				}
			};
			 
			Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(subscriber);
			
			Thread.sleep(1000 * 10);
			subscriber.unsubscribe();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
}
