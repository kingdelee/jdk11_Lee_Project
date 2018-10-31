package jdk11.thread.c_3;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Sequence2 {
	
	private int value;

	private static int v2;
	

	public synchronized int getNext() {
		return value ++;
	}
	public synchronized static int getNextStatic() {
		return v2 ++;
	}




}


class Sequence2Test  {


	public void newBefor(){

	}

	@Test
	public void t1(){
		Sequence2 sequence2 = new Sequence2();
		Sequence2 sequence3 = new Sequence2();

		new Thread(() -> {
			while(true){
				int a = sequence2.getNextStatic();


				System.out.println("a1:" + a);
			}
		}).start();

		new Thread(() -> {
			while(true){
				int a = sequence3.getNextStatic();
				System.out.println("a2:" + a);
			}
		}).start();

	}

}

class MyTest<T>{

	private List<T> list1 = new ArrayList();
	private List<T> list2 = new ArrayList();

	public void addInList1(T t){
		list1.add(t);
	}

	public void addInList2(T t){
		list2.add(t);
	}

}