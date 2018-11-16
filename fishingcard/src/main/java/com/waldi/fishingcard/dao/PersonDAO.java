package com.waldi.fishingcard.dao;

import java.util.List;

import com.waldi.fishingcard.model.Person;

public interface PersonDAO {

	// public UserInfo getUserInfo(String userName);
	public Person getPersonInfo(int personID);

	// [USER,AMIN,..]
	public List<Person> getPersonList();
	public void insertPerson(Person person);
	public void deletePerson(String personLogin);
	public void updatePerson(Person person);

	public Person findPersonByName(String name);
	public void save(Person person);

}
