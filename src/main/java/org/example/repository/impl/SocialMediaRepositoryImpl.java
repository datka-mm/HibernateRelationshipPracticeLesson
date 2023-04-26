package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.example.entity.Person;
import org.example.entity.SocialMedia;
import org.example.repository.SocialMediaRepository;

import java.util.ArrayList;
import java.util.List;

public class SocialMediaRepositoryImpl implements SocialMediaRepository {

    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveSocialMedia(SocialMedia socialMedia) {
        entityManager.getTransaction().begin();
        entityManager.persist(socialMedia);
        entityManager.getTransaction().commit();
        entityManager.close();
        return socialMedia.getSocialMediaName() + " is saved!";
    }

    @Override
    public String assignSocialMediaToPerson(Long personId, Long socialMediaId) {
        entityManager.getTransaction().begin();
        Person person = entityManager.createQuery("select p from Person p where p.id = ?1", Person.class).setParameter(1, personId).getSingleResult();
        SocialMedia socialMedia = entityManager.find(SocialMedia.class, socialMediaId);
        person.getSocialMediaList().add(socialMedia);
        socialMedia.getPeople().add(person);
//        entityManager.merge(socialMedia);
//        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return socialMedia.getSocialMediaName() + " assigned to person " + person.getPersonName();
    }

    @Override
    public String saveSocialMediaToPerson(Long personId, SocialMedia socialMedia) {
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, personId);
        entityManager.persist(socialMedia);
        person.getSocialMediaList().add(socialMedia);
        socialMedia.setPeople(List.of(person));
        entityManager.getTransaction().commit();
        entityManager.close();
        return socialMedia.getSocialMediaName() + " saved and assigned to " + person.getPersonName();
    }

    @Override
    public List<SocialMedia> getSocialMediasByPersonId(Long personId) {
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, personId);
        List<SocialMedia> socialMediaList = new ArrayList<>(person.getSocialMediaList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return socialMediaList;
    }

    @Override
    public void deleteSocialMediaById(Long id) {

    }

    @Override
    public void deleteSocialMediaByPersonId(Long personId) {

    }

    @Override
    public List<SocialMedia> getSocialMediaByPersonId(Long personId) {
        return null;
    }

    @Override
    public SocialMedia getOneSocialMediaByPersonId(Long personId) {
//        entityManager.getTransaction().begin();
//        Person person = entityManager.find(Person.class, personId);
//        List<SocialMedia> socialMediaList = new ArrayList<>(person.getSocialMediaList());
//        for (SocialMedia m : socialMediaList) {
//            return m;
//        }
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, personId);
        TypedQuery<SocialMedia> personId1 = entityManager.createQuery(
                "select p from Person p " +
                        "join p.socialMediaList s join s.people sp where sp.id = p.id "
                ,SocialMedia.class);
//        personId1.setParameter("personId", personId);
        List<SocialMedia> socialMediaList = personId1.getResultList();
        for (SocialMedia m : socialMediaList) {
            System.out.println(m);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        return null;
    }
}
