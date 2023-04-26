package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entity.Person;
import org.example.entity.SocialMedia;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateConfig {

    public static EntityManager getEntityManager() {
        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/for_practice");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "1234");
        configuration.setProperty(HBM2DDL_AUTO, "update");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(SHOW_SQL, "true");
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(SocialMedia.class);
        return configuration.buildSessionFactory().createEntityManager();
    }
}
