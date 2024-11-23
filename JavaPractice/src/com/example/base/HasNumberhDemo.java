package com.example.base;

public class HasNumberhDemo {
	public static void main(String[] args) {
		System.out.println("1:" + new CustomHashReferenceGenerator().hashCode());
		System.out.println("2:" + new CustomHashReferenceGenerator().hashCode());
		System.out.println("3:" + new CustomHashReferenceGenerator().hashCode());
		CustomHashReferenceGenerator a = new CustomHashReferenceGenerator();
		CustomHashReferenceGenerator b = a;
		System.out.println(a);
		System.out.println(b);
		if (a == b) {
			System.out.println("equal");
		}

		String a1 = "abc";
		String b1 = "abc";
		if (a1 == b1) {
			System.out.println("equal");
		}

	}
}
