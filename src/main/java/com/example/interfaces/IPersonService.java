package com.example.interfaces;

import com.example.models.Person;

public interface IPersonService {
	Person[] list();
	Person get(String id);
	void add(Person person);
	void edit(Person person);
	void delete(String id);
}
