package com.demo.ejb.sessionbean;

import java.util.List;

import javax.ejb.Local;

import com.demo.ejb.models.Person;

@Local
public interface CrudLocal {
	 public void addition(Person person);
	 public List<Person> findAll();
	 public Person findById(int id);
	 public void removeById(int id);
	 public void edit(Person p);
	 

}
