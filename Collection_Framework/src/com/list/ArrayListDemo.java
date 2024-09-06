package com.list;
import java.util.*;

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
//		
		list.add(10);
		list.add(20);
		
		for (int i =1; i<=10; i++) {
			list.add(i);
		}
		System.out.println(list);
	
		
	}

}
