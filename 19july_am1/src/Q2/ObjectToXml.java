package Q2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectToXml {
	
	public static void main(String ...strings) throws JAXBException, FileNotFoundException
	{
		JAXBContext contextObj = JAXBContext.newInstance(Employee.class);  
		  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
	    Address address=new Address("saharanpur","up",247001);
	  
	    Employee emp1=new Employee(1,"kunal","juneja",address);  
	      
	    marshallerObj.marshal(emp1, new FileOutputStream("employee.xml"));  
	}

}
