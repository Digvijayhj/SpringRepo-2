package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

public interface PersonRepo extends CrudRepository<Person, Integer>
{

	List<Person> findByLang(String lang);

	List<Person> findByPname(String pname);

	List<Person> findByPidGreaterThan(int pid);

	@Query("from Person where lang =?1 order by pname")	//case sensitive table name
	List<Person> findByLangSorted(String lang);
	
}
