package com.example.java;

interface A {
	void show(String name);
}

public class AnanymousInterfaceDemo {

	public static void main(String[] args) {
		A a = new A() {
			public void show(String name) {
				System.out.println("Ananymous Class");
			}
		};
		a.show("Pattabhi");

		int[] intArr = new int[] { 1, 2, 3, 4 };
		int[] intArr2 = { 11, 12, 13 };
	}
}
