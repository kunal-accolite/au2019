package com.accolite.au.assignments;

public class Book implements Comparable<Book>{
	private int isbn;
	private String name;
	private float price;
	private String authorName;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Book(int isbn, String name, float price, String authorName) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.authorName = authorName;
	}
	@Override
	public String toString()
	{
		return this.isbn + " " + this.name + " " + this.price + " " + this.authorName;
	} 
	
	 public int compareTo(Book book) {  
		    return name.compareTo(book.name);  }
	
}
