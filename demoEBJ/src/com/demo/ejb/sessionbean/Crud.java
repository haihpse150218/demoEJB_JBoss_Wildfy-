package com.demo.ejb.sessionbean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.demo.ejb.initialData.InitialData;
import com.demo.ejb.models.Person;

/**
 * Session Bean implementation class Crud
 */
@Stateless
@LocalBean
public class Crud implements CrudRemote, CrudLocal {

    /**
     * Default constructor. 
     */
    public Crud() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addition(Person person) {
		InitialData.getInstance().list.add(person);
		
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return InitialData.getInstance().list;
	}

	@Override
	public Person findById(int id) {
		Person result = null;
        for (Person p : findAll()) {
            if(p.getId() == id){
                result = p;
            }
        }
        return result;
	}

	@Override
	public void removeById(int id) {
		InitialData.getInstance().list.remove(findById(id));
		
	}

	@Override
	public void edit(Person p) {
		for (Person o : InitialData.getInstance().list) {
            if(o.getId() == p.getId()){
                o.setAddress(p.getAddress());
                o.setEmail(p.getEmail());
                o.setName(p.getName());
                o.setPhone(p.getPhone());
            }
        }
		
	}

}
