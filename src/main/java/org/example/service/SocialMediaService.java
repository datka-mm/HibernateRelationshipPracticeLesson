package org.example.service;

import org.example.entity.SocialMedia;

import java.util.List;

public interface SocialMediaService {

    String saveSocialMedia(SocialMedia socialMedia);

    String assignSocialMediaToPerson(Long personId, Long socialMediaId);

    String savePersonsSocialMedia(Long personId, SocialMedia socialMedia);

    List<SocialMedia> getSocialMediasByPersonId(Long personId);

    void deleteSocialMediaById(Long id);

    void deleteSocialMediaByPersonId(Long personId);

    List<SocialMedia> getSocialMediaByPersonId(Long personId);

    SocialMedia getOneSocialMediaByPersonId(Long personId);
}
