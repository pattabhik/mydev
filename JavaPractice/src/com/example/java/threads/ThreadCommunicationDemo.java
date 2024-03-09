package com.example.java.threads;

/**
 *
 * @author Pattabhi
 */

class ThreadCommunication {
	public synchronized void run() {
		System.out.println("Just started running");
		try {
			wait();
			System.out.println("Put on pause");
		} catch (InterruptedException e) {
		}
		System.out.println("Pause got released");
	}

	public synchronized void resuming() {
		notify();
		System.out.println("resumed");
	}
}

public class ThreadCommunicationDemo {

	public static void main(String[] args) {
		ThreadCommunication tc = new ThreadCommunication();
		Thread t1 = new Thread(() -> {
			tc.run();
		});
		Thread t2 = new Thread(() -> {
			tc.resuming();
		});
//t1.yield();
		t1.start();
		t1.start();
		t2.start();

	}
}
