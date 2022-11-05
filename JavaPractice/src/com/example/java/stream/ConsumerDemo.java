package com.example.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		Integer[] intArray = {1,2,3,4,5,6,7,8,9};
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> evnList = new ArrayList<>();
		Consumer<Integer> consImpl = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {

			}
		};

		list.forEach(i -> {
			if (i % 2 == 0) {
				evnList.add(i);
			}
		});
		
		evnList.forEach(System.out::println);
		
		Runnable runnable = () ->{
				System.out.println();
		};
		
		Runnable runnable2 = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
			
		};
	}

}
