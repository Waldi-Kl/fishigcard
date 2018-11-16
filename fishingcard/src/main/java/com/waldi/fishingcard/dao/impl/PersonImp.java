package com.waldi.fishingcard.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.waldi.fishingcard.dao.PersonDAO;
import com.waldi.fishingcard.mapper.PersonMapper;
import com.waldi.fishingcard.model.Person;

@Service
public class PersonImp extends JdbcDaoSupport implements PersonDAO {
	
	@Autowired
	public PersonImp(DataSource dataSource) {
		this.setDataSource(dataSource);
	}


	@Override
	public Person getPersonInfo(int personID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersonList() {
		// TODO Auto-generated method stub
		String sql = PersonMapper.BASE_SQL;
		Object[] params = new Object[] {};
		PersonMapper mapper = new PersonMapper();
		List<Person> lista = this.getJdbcTemplate().query(sql, params, mapper);
		return  lista;
	}

	@Override
	public void insertPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(String personLogin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findPersonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		
	}

}
