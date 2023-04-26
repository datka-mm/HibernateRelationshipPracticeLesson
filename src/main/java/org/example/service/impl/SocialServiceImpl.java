package org.example.service.impl;

import org.example.entity.SocialMedia;
import org.example.repository.SocialMediaRepository;
import org.example.repository.impl.SocialMediaRepositoryImpl;
import org.example.service.SocialMediaService;

import java.util.List;

public class SocialServiceImpl implements SocialMediaService {

    SocialMediaRepository socialMediaRepository = new SocialMediaRepositoryImpl();

    @Override
    public String saveSocialMedia(SocialMedia socialMedia) {
        return socialMediaRepository.saveSocialMedia(socialMedia);
    }

    @Override
    public String assignSocialMediaToPerson(Long personId, Long socialMediaId) {
        return socialMediaRepository.assignSocialMediaToPerson(personId, socialMediaId);
    }

    @Override
    public String savePersonsSocialMedia(Long personId, SocialMedia socialMedia) {
        return socialMediaRepository.saveSocialMediaToPerson(personId, socialMedia);
    }

    @Override
    public List<SocialMedia> getSocialMediasByPersonId(Long personId) {
        return socialMediaRepository.getSocialMediasByPersonId(personId);
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
        return socialMediaRepository.getOneSocialMediaByPersonId(personId);
    }
}
