package com.example.java.threads;

public class SyncThread {
	private int count = 0;
	private Object obj = null;

	public synchronized void inc1() {
		System.out.println("inc1");
	}

	public synchronized void inc() {
		// (this)
		{
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.obj = "Me";
		}
		System.out.println(Thread.currentThread().getName() + ", before increse the count:" + this.count);
		this.count++;
		System.out.println(Thread.currentThread().getName() + " Outside synchronized");
		System.out.println(Thread.currentThread().getName() + ", " + this.count);
		System.out.println(Thread.currentThread().getName() + ", " + this.obj);
	}
}
