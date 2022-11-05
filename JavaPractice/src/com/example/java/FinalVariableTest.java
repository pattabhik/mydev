package com.example.java;

class ObjectRef {
	private String name;

	public ObjectRef(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class FinalVariableTest {

	public static void main(String[] args) {
		FinalVariableTest t = new FinalVariableTest();

		ObjectRef ref = new ObjectRef("P");
		System.out.println("main 1:" + ref.hashCode() + ", " + ref.getName());
		t.change(ref);
		System.out.println("main 2:" + ref.hashCode() + ", " + ref.getName());
	}

	public void change(ObjectRef ref) {
		System.out.println("change 1:" + ref.hashCode() + ", " + ref.getName());
		ref = new ObjectRef("K");
		ref.setName("K");
		System.out.println("change 2:" + ref.hashCode() + ", " + ref.getName());
	}

}


