package Q2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int Id;
	private String FirstName;
	private String LastName;
	Address address;
	@XmlAttribute
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@XmlElement
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	@XmlElement
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	@XmlElement
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee(int id, String firstName, String lastName, Address address) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		this.address = address;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName +"," + address+
				"]";
	}

}
