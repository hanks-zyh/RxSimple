package xyz.hanks.error;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public class RetryWhen {

	public static void main(String[] args) {
/*
		Observable.just(1L, 2L,3L,4L).doOnNext(new Action1<Long>() {

			@Override
			public void call(Long arg0) {
				System.out.println("next" + arg0);
				if (arg0 == 3) {
					Exceptions.propagate(new Exception("errrrrrrrrrrrrrr"));
				}
			}
		})
		.repeat()
		.subscribe(new Action1<Long>() {

			@Override
			public void call(Long arg0) {
				System.out.println("onNext" + arg0);
			}
		}, new Action1<Throwable>() {

			@Override
			public void call(Throwable arg0) {
				System.out.println("Error" + arg0);

			}
		}, new Action0() {

			@Override
			public void call() {
				System.out.println("onComplete");
			}
		});
		*/
		
		Observable.interval(1, 1,TimeUnit.SECONDS)
		.doOnNext(new Action1<Long>() {

			@Override
			public void call(Long arg0) {
				System.out.println("next" + arg0);

				if(arg0 == 3){
					 Exceptions.propagate(new TokenExpireException());
				}
			}
		})
		.compose(retryWhenTokenError())
		.subscribe(new Action1<Long>() {

			@Override
			public void call(Long arg0) {
				System.out.println("onNext:" + arg0);
			}
		}, new Action1<Throwable>() {

			@Override
			public void call(Throwable error) {
				System.out.println(error instanceof TokenExpireException);
				System.out.println("Error:" + error);

			}
		}, new Action0() {

			@Override
			public void call() {
				System.out.println("onComplete");
			}
		});

		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static <T> Observable.Transformer<T, T> retryWhenTokenError() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
            	
                return observable.retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                    @Override
                    public Observable<?> call(Observable<? extends Throwable> errors) {
                    	System.out.println("retryWhen:"+errors.toString());
                        return errors.flatMap(new Func1<Throwable, Observable<?>>() {
                            @Override
                            public Observable<?> call(Throwable error) {
                            	System.out.println("err:"+error );
                            	System.out.println(error instanceof TokenExpireException);
                                //  TokenExpireException 过期, 重试
                                if (error instanceof IOException) {
                                    try {
                                        System.out.println("刷新了token");
                                        return Observable.just(null);
                                    } catch (Exception e) {
                                        return Observable.error(e);
                                    }
                                }
                                // For anything else, don't retry
                                return Observable.error(error);
                            }
                        });
                    }
                });
            }
        };
	}
        
        
      static class TokenExpireException extends Exception{
    	   
       }
	
}
