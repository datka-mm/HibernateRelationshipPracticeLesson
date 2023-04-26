package org.example.repository;

import org.example.entity.Person;

import java.util.List;

public interface PersonRepository {

    String savePerson(Person person);

    Person getPersonById(Long id);

    String updatePerson(Long id, Person person);

    List<Person> getAllPeople();

    void deletePersonById(Long id);

    List<Person> getAllPeopleBySocialMediaId(Long socialMediaId);


}
