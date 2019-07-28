package Q1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainSerialization {
	public static void main(String ... ar) throws IOException
	{
		Address address1=new Address("delhi road","saharanpur","up",247001);
		Address address2=new Address("allahabad road","banaras","up",144041);

		
		Student student1=new Student("kunal","juneja",28,12,'A',84,address1);
		Student student2=new Student("vansh","pathak",57,11,'B',95,address2);

		List<Student> studentlist=new ArrayList<Student>();
		studentlist.add(student1);
		studentlist.add(student2);
		
		FileOutputStream fos=new FileOutputStream("serialize.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(studentlist);
		oos.flush();
		oos.close();
	}

}
