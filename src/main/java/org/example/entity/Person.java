package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(
            generator = "person_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "person_gen",
            sequenceName = "person_seq",
            allocationSize = 1)
    private Long id;
    private String personName;
    private int age;
    private String email;
    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH})
    private List<SocialMedia> socialMediaList;

    public Person(String personName, int age, String email) {
        this.personName = personName;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
