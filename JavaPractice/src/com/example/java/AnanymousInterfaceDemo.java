package com.example.java;

interface A {
	void show(String name);
}

public class AnanymousInterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A() {
			public void show(String name) {
				System.out.println("Ananymous Class");
			}
		};
		a.show("Pattabhi");
	}
}
