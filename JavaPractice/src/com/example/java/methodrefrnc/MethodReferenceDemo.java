package com.example.java.methodrefrnc;

interface MyFunctinalInterface {
	public void printaa(String arg);
}
public class MethodReferenceDemo {

	public static void main(String[] args) {

		// MethodReferenceStatic mrs = new MethodReferenceStatic();

		// MyFunctinalInterface jk = MethodReferenceStatic::print;

		// MyFunctinalInterface jk1 = mrs::print2;

		MyFunctinalInterface jk2 = MethodReferenceStatic::new;

		jk2.printaa("a");
	}

}
