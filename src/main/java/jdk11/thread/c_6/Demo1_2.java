package jdk11.thread.c_6;

import org.junit.jupiter.api.Test;

public class Demo1_2 {

	private int i = 0;

	public synchronized void a(int i) throws  InterruptedException {
		System.out.println(i);
		b(i);

	}

	public synchronized void b(int i) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(i);
	}

	@Test
	public void t1() throws InterruptedException {

		Demo1_2 demo2 = new Demo1_2();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					demo2.a(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread1.start();

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					demo2.b(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread2.start();

		Thread.sleep(30000);

	}

}
