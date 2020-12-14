package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao{
	private static List<Person> DB = new ArrayList<Person>();
	@Override
		// TODO Auto-generated method stub
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}
	@Override
	public List<Person> selectAllPerson() {
		return DB;
	}
	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return DB.stream()
				.filter(person -> person.getId().equals(id)).findFirst();
	}
	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personMayBe = selectPersonById(id);
		if(!personMayBe.isPresent()) {
			return 0;
		}
		DB.remove(personMayBe.get());
		return 1;
	}
	@Override
	public int updatePersonById(UUID id, Person person) {
		return selectPersonById(id)
		.map(p ->{
			int idx = DB.indexOf(person);
			if(idx>=0) {
				DB.set(idx, person);
				return 1;
			}
			return 0;
		})
		.orElse(0);
	}

}
