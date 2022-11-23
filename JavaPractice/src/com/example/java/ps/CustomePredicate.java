package com.example.java.ps;

import java.util.function.Predicate;

public class CustomePredicate implements Predicate<String> {

	@Override
	public boolean test(String t) {

		return t.length() > 0;
	}

}
