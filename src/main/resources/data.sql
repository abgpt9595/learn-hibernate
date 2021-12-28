create table person
(
  	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);
INSERT into PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES (10001, 'Abhinav', 'Kolkata', sysdate());
INSERT into PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES (10002, 'Vaibhav', 'Delhi', sysdate());	
INSERT into PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES (10003, 'Rahul', 'Hyderabad', sysdate());
INSERT into PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES (10004, 'Karan', 'Bengaluru', sysdate());