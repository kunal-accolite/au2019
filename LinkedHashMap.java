package com.accolite.au.assignments;

public class LinkedHashMap {

	private Node[] array1;
	private int capacity = 4;
	private Node header;
	private Node last;
	
	public LinkedHashMap() {
		array1 = new Node[capacity];
	}
	
	static class Node{
		int key, value;
		Node after, before, next;
		
		public Node(int key, int value, Node next)
		{
			this.key =  key;
			this.value= value;
			this.next = next;
		}
	}
	
	public void put(int Key, int value)
	{
		if(Key <=0)
			return;
		
		int hash = hash(Key);
		
		Node newEntry = new Node(Key,value,null);
		if(header==null)
		{
			header = newEntry;
			last =  newEntry;
			newEntry.after = null;
			newEntry.before = null;
			
		}
		
		else{
			last.after = newEntry;
			newEntry.before = last;
			newEntry.after = null;
			last = newEntry;
		}
		
		if(array1[hash]==null)
		{
			array1[hash]= newEntry;
			newEntry.next =  null;
		}
		else{
			Node temp =  array1[hash];
			while(temp.next!=null)
			{
				temp =  temp.next;
			}
			temp.next= newEntry;
			
		}
	}
	
	private int hash(int key){
		return key%capacity;
	}
	
	public void display()
	{
		Node temp =  header;
		while(temp!=null)
		{
			System.out.println(temp.value);
			temp =  temp.after;
		}
		
		for(int i =0;i<capacity;i++)
		{
			System.out.println("List in index"+i+"=");
			temp = array1[i];
			while(temp!=null)
			{
				System.out.println(temp.value);
				temp =  temp.next;
			}
			
		}
	}
	public int get(int key)
	{
		int hash =  hash(key);
		int value = -1;
		Node temp = array1[hash];
		while(temp!=null)
		{
			if(temp.key==key)
			{
				value = temp.value;
				break;
			}
			temp =  temp.next;
		}
		return value;
	}
	
	public int delete(int key)
	{
		int hash =  hash(key);
		int value = -1;
		Node temp = array1[hash];
		Node prev = null;
		while(temp!=null)
		{
			if(temp.key==key)
			{
				if(temp==header)
				{
					header = temp.after;
				}
				if(temp.before!=null){
					temp.before.after =  temp.after;
				}
				if(temp.after!=null){
					temp.after.before =  temp.before;
				}
				if(prev==null)
				{
					array1[hash]=temp.next;
				}
				else{
					prev.next = temp.next;
				}
				value =  temp.value; 
				break;
			}
			prev =  temp;
			temp = temp.next;
		}
		return value;
	}
	public static void main(String args[]){
		LinkedHashMap ob = new LinkedHashMap();
		ob.put(1,2);
		ob.put(2, 50);
		ob.put(10,40);
		ob.put(20,45);
		ob.display();
		int value =  ob.get(21);
		if(value==-1)
			System.out.println("Key not found");
		else
			System.out.println("The value for the key is = "+value);
		value =  ob.delete(21);
		if(value==-1)
			System.out.println("Key not found");
		else
			System.out.println("The  value for the deleted key is = "+value);
		ob.display();
		value =  ob.delete(99);
		if(value==-1)
			System.out.println("Key not found");
		else
			System.out.println("The  value for the deleted key is = "+value);
		ob.display();
		
	}
	
}
