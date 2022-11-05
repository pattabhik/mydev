package com.example.java.threads;

public class ThreadTest {

	public static void main(String[] args) {
		SyncThread st = new SyncThread();
		Thread t1 = new Thread(() -> {
			st.inc();
		}, "Thread1");

		Thread t2 = new Thread(() -> {
			st.inc();
		}, "Thread2");

		t1.start();
		t2.start();
	}

}
