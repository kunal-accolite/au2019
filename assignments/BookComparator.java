package com.accolite.au.assignments;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) 
	{
		if(o1.getPrice()==o2.getPrice()) //if price is same then compare with respect to name alphabetically
		{
			return o1.getName().compareTo(o2.getName());
		}
		else if(o1.getPrice()>o2.getPrice())
			return 1;
		else
			return -1;
	}
}
