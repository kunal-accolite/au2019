package Q1;

import java.io.Serializable;

public class Student extends Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private int studentId;
	private int standard;
	private char division;
	private transient int mark;
	Address address;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public char getDivision() {
		return division;
	}
	public void setDivision(char division) {
		this.division = division;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Student(String first_name,String last_name,int studentId, int standard, char division, int mark, Address address) {
		super(first_name,last_name);
		this.studentId = studentId;
		this.standard = standard;
		this.division = division;
		this.mark = mark;
		this.address = address;
	}
	
}
