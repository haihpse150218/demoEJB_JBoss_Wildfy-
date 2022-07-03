package com.demo.ejb.initialData;

import java.util.ArrayList;
import java.util.List;

import com.demo.ejb.models.Person;

public class InitialData {
	   private static InitialData instance = new InitialData();
	   public static List<Person> list ;
	    public InitialData() {
	        list = initData();
	    }
	    public static InitialData getInstance(){
	        if(instance == null){
	            instance = new InitialData();
	        }
	        return instance;
	    }   
	    
	    public List<Person> initData(){
	        List<Person> list = new ArrayList<>();
	        list.add(new Person(1,"Thomas Hardy","thomashardy@mail.com","89 Chiaroscuro Rd, Portland, USA","(171) 555-2222"));
	        list.add(new Person(2,"Dominique Perrier","dominiqueperrier@mail.com","Obere Str. 57, Berlin, Germany","(313) 555-5735"));
	        list.add(new Person(3,"Maria Anders","mariaanders@mail.com","Via Monte Bianco 34, Turin, Italy, USA","(171) 555-2222"));
	        list.add(new Person(4,"Fran Wilson","franwilson@mail.com","89 Chiaroscuro Rd, Portland, USA","(171) 555-2222"));
	        list.add(new Person(5,"Martin Blank","thomashardy@mail.com","C/ Araquil, 67, Madrid, Spain, USA","(171) 555-2222"));
	        list.add(new Person(6,"Thomas Hardy","martinblank@mail.com","Via Monte Bianco 34, Turin, Italy","(171) 555-2222"));
	        return list;     
	    }
	}