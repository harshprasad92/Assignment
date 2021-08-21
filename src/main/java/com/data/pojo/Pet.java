package com.data.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Pet {

	public Pet() {
		this.name = "PetName" + new Random().nextInt(100);
		this.dateOfBirth = "2020-10-10";
		setPetType();
	}

	String name;
	String dateOfBirth;
	String petType;
	ArrayList<String> type = new ArrayList<>(Arrays.asList("bird", "cat", "dog", "hamster", "lizard", "snake"));

	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType() {
		this.petType = type.get(new Random().nextInt(type.size()));
	};

}
