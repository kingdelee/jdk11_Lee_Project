package jdk11.thread.c_ta7;

public class PushTarget implements Runnable {

	private Tmall tmall;
	
	public PushTarget(Tmall tmall2) {
		tmall = tmall2;
	}
	
	@Override
	public void run() {
		while(true) {
			tmall.push();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
