package com.wv.mfaraji.spring.react;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> all() {
		System.out.println("calleds");
		return personService.getAll();
	}
	
	@GetMapping("/persons/{id}")
	public Person find(@PathVariable int id) {
		System.out.println(id);
		return personService.get(id);
	}
	
	@DeleteMapping("/persons/{id}")
	public void remove(@PathVariable int id) {
		System.out.println("delete: " + id);
		personService.delete(id);
	}
	
	@PostMapping("/persons")
	public Person add(@RequestBody Person person) {
		System.out.println(person);
		return personService.add(person);
	}
}
