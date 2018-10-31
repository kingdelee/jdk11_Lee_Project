package jdk11.thread.c_ta7;

public class TakeTarget implements Runnable {

	private Tmall tmall;


	public TakeTarget(Tmall tmall2) {
		tmall = tmall2;
	}

	@Override
	public void run() {
		while(true) {
			tmall.take();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
