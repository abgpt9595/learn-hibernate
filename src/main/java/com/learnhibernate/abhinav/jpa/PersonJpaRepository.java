package com.learnhibernate.abhinav.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learnhibernate.abhinav.model.Person;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {

	//Connect to Database
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id)
	{
		return entityManager.find(Person.class, id);
	}
	
	//Insert or Update in table
	public Person update(Person person)
	{
		return entityManager.merge(person);
	}
	
	//Delete by Id
	public void deleteById(int id)
	{
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	//Implementing Find All using JPQL(Java Persistence Query Language) Named Query
	public List<Person> findAll()
	{
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
}
