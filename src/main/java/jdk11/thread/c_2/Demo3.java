package jdk11.thread.c_2;

public class Demo3 {

    public static void main(String[] args) {
		
		/*new Thread() {
			public void run() {
				System.out.println("thread start ..");
			};
		}.start();*/
		
		
		/*new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread start ..");
			}
		}).start();*/

		new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

		new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }) {
            public void run() {
                System.out.println("sub");
            }

        }.start();


    }

}
