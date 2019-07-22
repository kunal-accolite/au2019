package com.accolite.au.assignments;
import java.util.Iterator;
import java.util.*;
import java.util.Scanner;
import java.util.TreeSet;
public class DuplicateStrings {
	public static void main(String ...a)
	{
		List<String> arraylist=new ArrayList<>();
		TreeSet<String> helper=new TreeSet<>();
		System.out.println("Enter the number of strings in the list");
		Scanner scan =new Scanner(System.in);
		int n=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<n;i++)
		{
			String s=scan.nextLine();
			if(arraylist.contains(s))
				helper.add(s);
			else
				arraylist.add(s);
		}
		Iterator<String> it=helper.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
