package com.accolite.au.assignments;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HashMapExample {
	public static void main(String ...a)
	{
		Map<String , Book> bookMap=new HashMap<>();
		Map<String , Integer> hashMap=new HashMap<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("How many books you want to enter ?");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{ 
			int isbn=sc.nextInt();
			sc.nextLine();
			String name=sc.nextLine();
			float price=sc.nextFloat();
			sc.nextLine();
			String authorName=sc.nextLine();
			Book book=new Book(isbn,name,price,authorName);
			if(bookMap.containsKey(authorName))
			{
				Integer count=hashMap.get(authorName);
				hashMap.replace(authorName, count+1);
			}
			else
			{
				bookMap.put(authorName, book);
				hashMap.put(authorName, 1);
			}
		}
		for(Entry<String,Integer> entry:hashMap.entrySet())
			if(entry.getValue()>2)
				System.out.println(entry.getKey());
	}
}
