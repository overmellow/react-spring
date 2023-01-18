package com.wv.mfaraji.spring.react;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
	static List<Person> persons = new ArrayList<Person>(); 
	
	public PersonService() {
		persons.addAll(Arrays.asList(
				new Person(1, "mori", "mori@mail"),
				new Person(2, "john", "john@mail"),
				new Person(3, "jack", "jack@mail")
				));
	}
	
	List<Person> getAll() {
		return persons;
	}
	
	Person get(int id) {
		return persons.stream().filter(p -> p.id == id).findAny().orElse(null);
	}
	
	Person add(Person p) {
		Person lastPerson = persons.get(persons.size() - 1);
		p.id = lastPerson.id + 1;
		persons.add(p);
		System.out.println(persons);
		return persons.get(persons.size() - 1);
	}
	
	void update(Person p) {
		persons.add(p);
	}
	
	void delete(int id) {
		persons = persons.stream().filter(p -> p.id != id).toList();
	}
}
