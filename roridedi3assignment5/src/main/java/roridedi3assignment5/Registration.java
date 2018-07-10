package roridedi3assignment5;

import java.util.List;
import java.util.Set;

public class Registration {
	private String firstName;
	private String email;
	private String employmentStatus;
	private String vehicle;
	private String price;
	private String total;
	private String hotelPrice;
	private List<Course> courses;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getHotelPrice() {
		return hotelPrice;
	}
	public void setHotelPrice(String hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	@Override
	public String toString() {
		return "Registration [firstName=" + firstName + ", email=" + email + ", employmentStatus=" + employmentStatus
				+ ", vehicle=" + vehicle + ", courses=" + courses + ", price=" + price + ", total=" + total
				+ ", hotelPrice=" + hotelPrice + "]";
	}

}
