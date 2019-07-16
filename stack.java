package com.accolite.au.assignments;
import java.util.*;
class stack 
{ 
	private int size;
	private int stackArray[];
	private int top=-1;
	public stack(int size)
	{
		this.size=size;
		stackArray=new int[this.size];
	}
    public void stack_push(int x) 
    { 
    	top++;
        stackArray[top]=x;
    } 
    public void stack_pop() 
    { 
    	if(isempty())
    	{
    		System.out.println("stack is empty");
    	}
    	else 
    	{
    		System.out.println("the popped element is : "+stackArray[top]);
    		top--;
    	}
    }  
    public void stack_size() 
    { 
        System.out.println("the size of stack is :"+(top+1));
    }  
    public boolean isempty()
    {
    	if(top<0)
    		return true;
    	else
    		return false;
    	
    }
    public boolean isfull()
    {
    	if(top==size)
    		return true;
    	else
    		return false;
    	
    }
    public static void main (String[] args) 
    { 
    	int size;
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter the size of stack");
		size=sc.nextInt();
		stack StackArray=new stack(size);
		outer:
    	while(true)
    	{
    		System.out.println("1. push\n2. pop\n3. size\n4. isempty\n5. isfull\n6. exit");
    		int i=sc.nextInt();
    		switch(i)
    		{
    			case 1:
    				int element;
    				System.out.println("enter the element to be pushed :");
    				element =sc.nextInt();
    				StackArray.stack_push(element);
    				break;
    			
    			case 2:
    				StackArray.stack_pop();
    				break;
    		
    			case 3:
    				StackArray.stack_size();
    	
    			case 4:
    				if(StackArray.isempty()) 
    					System.out.println("true");
    				else
    					System.out.println("false");
    				break;
    		
    			case 5:
    				if(StackArray.isfull())
    					System.out.println("true");
    				else
    					System.out.println("false");
    				break;
    			case 6:
    				break outer;
    				
    			default:
    				break;
    		}
    	} 
    } 
}
