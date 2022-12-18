package com.example.java.threads;

import java.util.Timer;

/**
 * @author Pattabhi
 *
 */

class MethodSync {
	public synchronized void print(String msg) {
		System.out.println("Saying msg:" + msg);
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
	}
}

public class SimpleThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MethodSync ms = new MethodSync();
		Thread t1 = new Thread(() -> ms.print("Thread1"));
		Thread t2 = new Thread(() -> ms.print("Thread2"));

		t1.start();
		t2.start();

		t1.setDaemon(false);
		
		Timer tmr = new Timer();
		// TimerTask tmrTsk = new TimerTask();
		
		// tmr.
	}

}
