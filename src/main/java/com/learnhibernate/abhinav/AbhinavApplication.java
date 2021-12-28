package com.learnhibernate.abhinav;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learnhibernate.abhinav.jdbc.PersonJdbcDao;
import com.learnhibernate.abhinav.jpa.PersonJpaRepository;
import com.learnhibernate.abhinav.model.Person;

@SpringBootApplication
public class AbhinavApplication implements CommandLineRunner{

	@Autowired
	PersonJdbcDao dao;
	
	@Autowired
	PersonJpaRepository jpaDao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(AbhinavApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//logger.info("All Users -> {} ", dao.findAll());
		//logger.info("Person By Id 10001 -> {} ", dao.findById(10001, "Abhinav"));
		//logger.info("Person with name by Karan -> {} ", dao.findByName("Karan"));
		
		//logger.info("Deleting 10002 : No. of Rows deleted -> {} ", dao.deleteById(10002));
		
		
		 //logger.info("Inserting 10006 -> {} ", dao.insert(new Person( 10006, "Raghav",
		 // "Chennai", new Date()))); 
		  
		 // logger.info("All Users -> {} ", dao.findAll());
		  
		 // logger.info("Updating 10003 -> {} ", dao.update(new Person( 10003,
		 // "Rahul Agarwal", "Hyderabad", new Date())));
		 
		 //logger.info("All Users -> {} ", dao.findAll());
		logger.info("Inserting -> {] ", jpaDao.update(new Person( 10001, "Abhinav",
		 "Kolkata", new Date())));
		logger.info("Inserting -> {] ", jpaDao.update(new Person( 10002, "Raghav",
				 "Chennai", new Date())));
		logger.info("Find By Id 2 -> {} ", jpaDao.findById(2));
		
		logger.info("Updating 1 -> {] ", jpaDao.update(new Person( 1, "Abhinav Gupta",
				 "Kolkata", new Date())));
		logger.info("Find By Id 1 -> {} ", jpaDao.findById(1));
		
		//logger.info("Calling Delete By Id");
		//jpaDao.deleteById(2);
		//logger.info("Find By Id 2 -> {} ", jpaDao.findById(2));
		
		logger.info("Find All -> {} " , jpaDao.findAll());
		
	}

}
