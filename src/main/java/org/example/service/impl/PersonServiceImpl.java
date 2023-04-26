package org.example.service.impl;

import org.example.entity.Person;
import org.example.repository.PersonRepository;
import org.example.repository.impl.PersonRepositoryImpl;
import org.example.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository = new PersonRepositoryImpl();

    @Override
    public String savePerson(Person person) {
        return personRepository.savePerson(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return null;
    }

    @Override
    public String updatePerson(Long id, Person person) {
        return null;
    }

    @Override
    public List<Person> getAllPeople() {
        return null;
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deletePersonById(id);
    }

    @Override
    public List<Person> getAllPeopleBySocialMediaId(Long socialMediaId) {
        return null;
    }
}
