package com.demo.ejb.models;

public class Person {
	private long id;
	private String Name;
	private String email;
	private String address;
	private String phone;

	public Person() {
	}

	public Person(long id, String Name, String email, String address, String phone) {
		this.id = id;
		this.Name = Name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", Name=" + Name + ", email=" + email + ", address=" + address + ", phone="
				+ phone + '}';
	}
}
