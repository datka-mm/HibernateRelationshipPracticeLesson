package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Person;
import org.example.entity.SocialMedia;
import org.example.service.PersonService;
import org.example.service.SocialMediaService;
import org.example.service.impl.PersonServiceImpl;
import org.example.service.impl.SocialServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Person person = new Person("Erbol", 19, "erbol@gmail.com");
        SocialMedia socialMedia = new SocialMedia("Instagram");


        PersonService personService = new PersonServiceImpl();
//        System.out.println(personService.savePerson(person));
        personService.deletePersonById(2L);


        //social media
        SocialMediaService service = new SocialServiceImpl();
//        System.out.println(service.saveSocialMedia(socialMedia));
//        System.out.println(service.assignSocialMediaToPerson(1L, 1L));
//        System.out.println(service.savePersonsSocialMedia(2L, new SocialMedia("Facebook")));
//        System.out.println(service.getSocialMediasByPersonId(1L));
//        System.out.println(service.getOneSocialMediaByPersonId(1L));
    }
}
