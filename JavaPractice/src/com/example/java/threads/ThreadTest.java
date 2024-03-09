package com.example.java.threads;

public class ThreadTest {

	public static void main(String[] args) {
		SyncThread st1 = new SyncThread();
		SyncThread st2 = new SyncThread();
		Thread t1 = new Thread(() -> {
			st1.inc();
		}, "Thread1");

		Thread t2 = new Thread(() -> {
			st1.inc1();
		}, "Thread2");

		t1.start();
		t2.start();
	}

}
