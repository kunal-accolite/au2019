package Q1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainDeserialization {
	public static void main(String ...strings ) throws IOException, ClassNotFoundException
	{
		FileInputStream fis=new FileInputStream("serialize.txt");
		ObjectInputStream ois =new ObjectInputStream(fis);
		ArrayList<Student> studentlist=(ArrayList<Student>) ois.readObject();
		ois.close();
		for(Student s : studentlist)
		{
			System.out.println(s.getFirst_name()+", "+s.getLast_name()+", "+s.getStudentId()+", "+s.getStandard()+", "+s.getDivision()
			+", "+s.getMark()+", "+s.getAddress().getStreet()+", "+s.getAddress().getCity()+", "+s.getAddress().getState()+", "+
					s.getAddress().getZip());
		}
		
	}

}
