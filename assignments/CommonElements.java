package com.accolite.au.assignments;

import java.util.Iterator;
import java.util.*;
import java.util.Scanner;
import java.util.TreeSet;


public class CommonElements {
	
		public static void main(String ...a)
		{
			List<String> arraylist1=new ArrayList<>();
			List<String> arraylist2=new ArrayList<>();
			TreeSet<String> treeset=new TreeSet<>();
			System.out.println("Enter the number of elements in the list 1:");
			Scanner scan =new Scanner(System.in);
			int n=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the elements in list 1");
			for(int i=0;i<n;i++)
			{
				String s=scan.nextLine();
				arraylist1.add(s); //add the elements to list
			}
			System.out.println("Enter the number of elements in the list 2:");
			int n1=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the elements in list 2");
			for(int i=0;i<n1;i++)
			{
				String s1=scan.nextLine();
				if(arraylist1.contains(s1)) // if list 1 contains this element then add it to treeset
					treeset.add(s1);
				arraylist2.add(s1);
			}
			
			Iterator<String> it=treeset.iterator();
			while(it.hasNext())
				System.out.println(it.next());
		}
	}

