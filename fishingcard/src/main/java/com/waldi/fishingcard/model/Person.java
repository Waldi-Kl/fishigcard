package com.waldi.fishingcard.model;

import java.util.Date;

public class Person {
	
	private int personId;
	private String pesel;		// PESEL to tylko 11 ostatnich cyfr. UWAGA na kodowanie miesi¹ca daty urodzin w numerze PESEL
	private String surname;
	private String name_1;
	private String name_2;
	private Date date;
	private String city;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName_1() {
		return name_1;
	}
	public void setName_1(String name_1) {
		this.name_1 = name_1;
	}
	public String getName_2() {
		return name_2;
	}
	public void setName_2(String name_2) {
		this.name_2 = name_2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	


}
