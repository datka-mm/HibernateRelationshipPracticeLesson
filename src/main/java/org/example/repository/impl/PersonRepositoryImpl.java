package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Person;
import org.example.repository.PersonRepository;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String savePerson(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return person.getPersonName() + " is saved!";
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
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Person with id: " + id + " deleted!");
    }

    @Override
    public List<Person> getAllPeopleBySocialMediaId(Long socialMediaId) {
        return null;
    }
}
