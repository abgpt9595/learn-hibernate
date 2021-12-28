package com.learnhibernate.abhinav.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learnhibernate.abhinav.model.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirth_date(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	//select * from person;
	public List<Person> findAll()
	{	
		//new BeanPropertyRowMapper<Person>(Person.class),
		return jdbcTemplate.query(
				"select * from person", new PersonRowMapper());
	}
	
	public Person findById(int id, String name)
	{
		return jdbcTemplate.queryForObject(
				"select * from person where id=? or name=?",
				//new BeanPropertyRowMapper<Person>(Person.class),
				new PersonRowMapper(),
				new Object[] {id , name}
				);
	}
	
	public List<Person> findByName(String name)
	{
		return jdbcTemplate.query(
				"select * from person where name=?",
				new BeanPropertyRowMapper<Person>(Person.class),
				new Object[] {name});
	}
	
	public int deleteById(int id)
	{
		return jdbcTemplate.update(
				"delete from person where id=?",
				new Object[] {id});
	}
	
	public int insert(Person person)
	{
		return jdbcTemplate.update(
				"insert into person (id, name, location, birth_date) " + 
				"values(?,?,?,?)", 
				new Object[] {person.getId(), person.getName(),
							person.getLocation(), new Timestamp(person.getBirth_date().getTime())});
	}
	
	public int update(Person person)
	{
		return jdbcTemplate.update(
				"update person set name = ? " + 
				"where id = ?",
				new Object[] {person.getName(), person.getId()});
	}
}
