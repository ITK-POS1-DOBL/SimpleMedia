/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;

/**
 * Concrete media repository implementation that stores media in a database.
 * 
 * @author intruder
 */
class MediaDBRepository implements IMediaRepository {

    @Resource
    private static EntityManager em;
    
    public MediaDBRepository() {
    }

    @Override
    public void add(Medium medium) {
        em.persist(medium);
    }

    @Override
    public Medium getMediumById(long Id) {
        return em.find(Medium.class, Id);
    }

    @Override
    public List<Medium> getCompleteMediaList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMedium(MediumDTO mediumDto) {
        Medium medium = em.find(Medium.class, Long.valueOf(mediumDto.getMediumIdString()));
        medium.setType(mediumDto.getMediumTypeString());
        medium.setTitle(mediumDto.getMediumTitleString());
        medium.setDescription(mediumDto.getMediumDescString());
        em.flush();
    }

    @Override
    public void deleteMediumById(Long mediumId) {
        em.remove(getMediumById(mediumId));
    }
    
}
