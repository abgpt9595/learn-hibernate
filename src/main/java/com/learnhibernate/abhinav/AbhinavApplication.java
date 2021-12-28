package com.learnhibernate.abhinav;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learnhibernate.abhinav.jdbc.PersonJdbcDao;

@SpringBootApplication
public class AbhinavApplication implements CommandLineRunner{

	@Autowired
	PersonJdbcDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(AbhinavApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {} ", dao.findAll());
		
	}

}
