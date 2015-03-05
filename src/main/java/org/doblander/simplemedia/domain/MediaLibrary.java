/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author intruder
 */
@Named
@ApplicationScoped
public class MediaLibrary {

    
    private static final Logger logger
            = Logger.getLogger("org.doblander.simplemedia.domain.MediaLibrary");
    
    private MediaRepository mediaRepo;

    public void insertMedium(String type, String title, String description) {
        Medium tempMedium = new Medium(type, title, description);

        mediaRepo.add(tempMedium);

        // Log-Output for debugging...
        logger.log(Level.INFO, "added medium: " + type + ", " + title
                + ", " + description);
    }

    /**
     * Searches the media store for the medium with the given ID
     *
     * @param Id the value of Id
     * @return the org.doblander.simplemedia.domain.MediumDTO
     */
    public MediumDTO findMediumById(long Id) {
        
        return mediaRepo.getMediumById(Id);
        
    }

    public List<MediumDTO> getFullInventory() {
        
        return mediaRepo.getCompleteMediaList();
        
    }
}
