/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.HashMap;
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

    private static ArrayList<Medium> mediaList = new ArrayList();
    
    private static HashMap mediaStore = new HashMap();

    private static final Logger logger
            = Logger.getLogger("org.doblander.simplemedia.domain.MediaLibrary");

    public void insertMedium(String type, String title, String description) {
        Medium tempMedium = new Medium(type, title, description);
        
        mediaList.add(tempMedium);
        mediaStore.put(tempMedium.getId(), tempMedium);
        
        // Log-Output for debugging...
        logger.log(Level.INFO, "added medium: " + type + ", " + title
                + ", " + description);
    }
    
    /**
     * Searches the media store for the medium with the given ID
     * @param Id the value of Id
     * @return the org.doblander.simplemedia.domain.MediumVO
     */
    public MediumVO findMediumById(long Id) {
        Medium currentMedium = null;
        // use array list
        while (mediaList.iterator().hasNext()) {
            currentMedium = mediaList.iterator().next();
            if (Id == currentMedium.getId()) {
                return currentMedium.createVO();
            }
            else {
                //currentMedium = null;
            }
        }
        
        return currentMedium.createVO();
    }
}
