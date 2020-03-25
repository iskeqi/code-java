package com.keqi.springbootmapstruct.domain;

public class DeliveryAddress {

	private String firstName;

	private String lastName;

	private int height;

	private String street;

	private int zipCode;

	private int houseNumber;

	private String description;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DeliveryAddress{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", height=" + height +
				", street='" + street + '\'' +
				", zipCode=" + zipCode +
				", houseNumber=" + houseNumber +
				", description='" + description + '\'' +
				'}';
	}
}
