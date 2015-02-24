/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
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

    private static final Logger logger
            = Logger.getLogger("org.doblander.simplemedia.domain.MediaLibrary");

    public void insertMedium(String type, String title, String description) {
        mediaList.add(new Medium(type, title, description));
        // Log-Output for debugging...
        logger.log(Level.INFO, "added medium: " + type + ", " + title
                + ", " + description);
    }
}
