package com.accolite.au.assignments;
import java.util.*;

public class ListSorting {
	public static void main(String ...a)
	{
		List<Book> bookList=new ArrayList<>();
		bookList.add(new Book(1,"Big Data",300,"HC Verma"));
		bookList.add(new Book(2,"Web App",400,"Dan Brown"));
		bookList.add(new Book(3,"Java Core",500,"RD Sharma"));
		bookList.add(new Book(4,"Machine Learning",600,"KP Verma"));
		bookList.add(new Book(5,"C In Depth",200,"SK Shrivastav"));
		bookList.add(new Book(6,"Let Us C",200,"Dennis Richie"));
		bookList.add(new Book(7,"Make In India",300,"Narendra Modi"));
		bookList.add(new Book(8,"Python Learning",200,"Prabhtaj Singh"));
		bookList.add(new Book(9,"Scala",200,"Kunal Juneja"));
		bookList.add(new Book(10,"Let Us See",400,"Kunal Juneja"));
		
		bookList.sort(new BookComparator());
		//System.out.println(bookList);
		/*Collections.sort(bookList);
		System.out.println(bookList);*/
		Iterator it=bookList.iterator();
		while(it.hasNext())
		{
			Book book=(Book) it.next();
			book.setPrice(book.getPrice()-0.2f*book.getPrice());
		}
		System.out.println(bookList);
		
	}
}
