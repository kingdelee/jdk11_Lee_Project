package jdk11.thread.c_ta3;

public class Main {
	
	public static void main(String[] args) {
		
		
		Demo d = new Demo();
//		d.put("key1", "value1");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.put("key1", "value1");
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(d.get("key1"));
			}
		}).start();


		System.out.println("1");
		System.out.println("2");
		System.out.println("3");


		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(d.get("key1"));
//			}
//		}).start();
//
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(d.get("key1"));
//			}
//		}).start();
//
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(d.get("key1"));
//			}
//		}).start();
//
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.put("key3", "value3");
//			}
//		}).start();
		
		
	}

}
