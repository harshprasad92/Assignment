package com.data.pojo;

import java.util.Random;

public class Owner {

	String firstName;
	String lastName;
	String address;
	String city;
	String phone;

	public Owner() {
		this.firstName = "testFirstname" + new Random().nextInt(1000);
		this.lastName = "testLastname" + new Random().nextInt(1000);
		this.address = "test address";
		this.city = "Dubai";
		this.phone = "055" + new Random().nextInt(1000000);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPhone() {
		return phone;
	}

}
