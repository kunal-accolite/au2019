package au;
import au.Employee;
import au.Utility;

public class Main {
	
	public static void main(String[] args) {
		Employee e = new Employee(1, "kunal",23);
		System.out.println(Utility.convertToJSON(e));
	}

}