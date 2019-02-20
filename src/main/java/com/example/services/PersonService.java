package com.example.services;

import java.util.ArrayList;
import java.util.UUID;

import com.example.interfaces.IPersonService;
import com.example.models.Person;

public final class PersonService implements IPersonService {

	private PersonService() {
		super();
	}
	
	public static PersonService getInstance() {
		if (instance == null) {
			instance = new PersonService();
		}
		return instance;
	}
	
	public Person[] list() {
		Person[] persons = new Person[database.size()];
		for (int i = 0; i < database.size(); i++) {
			persons[i] = database.get(i);
		}
		return persons;
	}
	
	public Person get(String id) {
		for (Person person : database) {
			if (person.getId().equals(id)) {
				return person;
			}
		}
		return null;
	}
	
	public void add(Person person) {
		database.add(person);
	}

	public void edit(Person personUpdated) {
		for (Person person : database) {
			if (person.getId().equals(personUpdated.getId())) {
				person.setName(personUpdated.getName());
				person.setAge(personUpdated.getAge());
			}
		}
	}

	public void delete(String id) {
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getId().equals(id)) {
				database.remove(i);
			}
		}
	}
	
	private static ArrayList<Person> database = new ArrayList<Person>();
	static {
		database.add(new Person(UUID.randomUUID().toString(), "Pepe", 28));
		database.add(new Person(UUID.randomUUID().toString(), "Lau", 26));
		database.add(new Person(UUID.randomUUID().toString(), "Pau", 31));
		database.add(new Person(UUID.randomUUID().toString(), "Hugo", 25));
	}
	
	private static PersonService instance;
	
}
