package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "social_medias")
@Getter
@Setter
@NoArgsConstructor
public class SocialMedia {

    @Id
    @GeneratedValue(
            generator = "social_media_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "social_media_gen",
            sequenceName = "social_media_seq",
            allocationSize = 1)
    private Long id;
    private String socialMediaName;
    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH},
            mappedBy = "socialMediaList")
    private List<Person> people;

    public SocialMedia(String socialMediaName) {
        this.socialMediaName = socialMediaName;
    }

    @Override
    public String toString() {
        return "SocialMedia{" +
                "id=" + id +
                ", socialMediaName='" + socialMediaName + '\'' +
                '}'+ "\n";
    }
}
