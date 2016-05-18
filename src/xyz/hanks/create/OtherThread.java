package xyz.hanks.create;

import rx.Observable;

public class OtherThread {

	public static void main(String[] args) {
		Observable.just(1,2,3)
		 .doOnNext(s->System.out.println(s))
		 .map(s->{
			 new Thread(){
					public void run() {
						try {
							Thread.sleep(3000);
							System.out.println("sleep:"+s);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			 }.start();
			 return s;
		 })
		 .subscribe(s->System.out.println("end:"+s), 
				 e->System.out.println(e));
	}
}
