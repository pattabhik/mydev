package com.example.java.threads;

public class SyncThread {

	private int count = 0;
	private Object obj = null;

	public void inc() {

		synchronized (this) {
			/*
			 * try { // Thread.sleep(4000); } catch (InterruptedException e) {
			 * e.printStackTrace(); }
			 */
			this.obj = "Me";

		}
		this.count++;
		System.out.println(Thread.currentThread().getName() + " Outside synchronized");
		System.out.println(Thread.currentThread().getName() + ", " + this.count);
		System.out.println(Thread.currentThread().getName() + ", " + this.obj);
	}
}
