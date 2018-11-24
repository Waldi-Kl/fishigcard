package com.waldi.fishingcard.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.waldi.fishingcard.model.Person;
import com.waldi.fishingcard.model.UserInfo;

public class PersonMapper implements RowMapper<Person> {
	
	public static final String BASE_SQL = 

	"Select p.PER_ID, p.PER_PESEL, p.PER_SURNAME, p.PER_NAME1, p.PER_NAME2, p.PER_BIRTH_DATE, p.PER_CITY, p.ADR_ID from person p ";
	
	private int personId ;
	private String pesel;
	private String surname;
	private String name_1;
	private String name_2;
	private Date date;
	private String city;
	private int adresId;

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		this.personId = rs.getInt("PER_ID");
		this.pesel = rs.getString("PER_PESEL");
		this.surname = rs.getString("PER_SURNAME");
		this.name_1 = rs.getString("PER_NAME1");
		this.name_2 = rs.getString("PER_NAME2");
		this.date = rs.getDate("PER_BIRTH_DATE");
		this.city = rs.getString("PER_CITY");
		this.adresId = rs.getInt("ADR_ID");

		//this.peselMaker();

        Person person = new Person();
        person.setPersonId(this.personId);
        person.setSurname(this.surname);
        person.setPesel(this.pesel);
        person.setName_1(this.name_1);
        person.setName_2(this.name_2);
        person.setDate(this.date);
        person.setCity(this.city);
        person.setAdresId(this.adresId);
        
		return person;
	}
	
	private void peselMaker() {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.date);
		String day = "";
		String month = "";
		String year = "";
		
		year = Integer.toString(cal.get(Calendar.YEAR));
		if (cal.get(Calendar.DAY_OF_MONTH) < 10) day = "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH)); else day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		
		
		if(year.substring(0,2).equals("19")){
			
		if ((cal.get(Calendar.MONTH)+1) < 10) month = "0" + Integer.toString(cal.get(Calendar.MONTH)+1); 
		else month = Integer.toString(cal.get(Calendar.MONTH)+1);}
	
		else{
			
			if ((cal.get(Calendar.MONTH)+1) < 10) month = "2" + Integer.toString(cal.get(Calendar.MONTH)+1); 
			else month = "3" + Integer.toString(cal.get(Calendar.MONTH)+1).substring(1, 1);
		}
		
		this.pesel = year.substring(2) + month + day + pesel;
		
	}

	public int getAdresId() {
		return adresId;
	}

	public void setAdresId(int adresId) {
		this.adresId = adresId;
	}

}
