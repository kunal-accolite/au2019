package Q2;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;  

@XmlRootElement
public class Address {
	private String city;
	private String state;
	private int zip;
	
	public Address(String city, String state, int zip) {
		super();
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Address() {
		super();
	}
	@XmlElement
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@XmlElement
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@XmlElement
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return " city= " + city + ", state=" + state + ", zip=" + zip;
	}

}
