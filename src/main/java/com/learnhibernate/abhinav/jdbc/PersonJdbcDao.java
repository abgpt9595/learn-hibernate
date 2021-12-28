package com.learnhibernate.abhinav.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learnhibernate.abhinav.model.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//select * from person;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Person> findAll()
	{
		return jdbcTemplate.query(
				"select * from person", new BeanPropertyRowMapper(Person.class));
	}
}
