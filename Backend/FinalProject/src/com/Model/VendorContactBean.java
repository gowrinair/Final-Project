package com.Model;

public class VendorContactBean {
	
	
	//instance variables of Vendor Table
	
	private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private int pincode;
	private String vStatus;
	
	//instance variables of Contact Table
	
	private int contactId;
	private String contactName;
	private String department;
	private String email;
	private String phone;
	
	//instance variables of login table
	private int userId;
	private String username;
	private String password;
	
	
	

	
	//Getter and setters of login table
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//Getter and setters of vendor table
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getvStatus() {
		return vStatus;
	}
	public void setvStatus(String vStatus) {
		this.vStatus = vStatus;
	}
	
	
	
	//parameterized constructor for vendor table
	public VendorContactBean(String vendorName, String address, String location, String service, int pincode,
			String vStatus) {
		super();
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.vStatus = vStatus;
	}
	
	
	//Getter and setters of Contact Table
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//parameterized constructor for contact table
	public VendorContactBean(String contactName, String department, String email, String phone) {
		super();
		this.contactName = contactName;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}
	
	
	public VendorContactBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parameterized constructor for login table
	public VendorContactBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	 
}
