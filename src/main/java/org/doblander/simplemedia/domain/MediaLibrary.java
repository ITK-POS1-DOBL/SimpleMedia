/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.doblander.simplemedia.util.SimpleMediaLogger;

/**
 *
 * @author intruder
 */
@Named
@ApplicationScoped
public class MediaLibrary {

    private static ArrayList<Medium> mediaList = new ArrayList();

    private static HashMap mediaStore = new HashMap();


    public void insertMedium(String type, String title, String description) {
        Medium tempMedium = new Medium(type, title, description);

        mediaList.add(tempMedium);
        mediaStore.put(tempMedium.getId(), tempMedium);

        // Log-Output for debugging...
        SimpleMediaLogger.logInfo("added medium: " + type + ", " + title
                + ", " + description);
    }

    /**
     * Searches the media store for the medium with the given ID
     *
     * @param Id the value of Id
     * @return the org.doblander.simplemedia.domain.MediumVO
     */
    public MediumVO findMediumById(long Id) {
        Medium currentMedium = null;
        // use array list
        Iterator iterator = mediaList.iterator();
        while (iterator.hasNext()) {
            currentMedium = (Medium)iterator.next();
            if (Id == currentMedium.getId()) {
                return currentMedium.createVO();
            } else {
                currentMedium = null;
            }
        }

        return null;
    }

    public List<MediumVO> getFullInventory() {
        ArrayList<MediumVO> inventory = new ArrayList<MediumVO>();

        SimpleMediaLogger.logInfo("hasNext at entry: " + Boolean.toString(mediaList.iterator().hasNext()));
        int cnt = 1;
        Iterator iterator = mediaList.iterator();
        //while (mediaList.iterator().hasNext()) {
        //MediumVO mediumval = ((Medium)iterator.next()).createVO();
        while (iterator.hasNext()) {
            inventory.add(((Medium)iterator.next()).createVO());
            SimpleMediaLogger.logInfo("in loop / current cnt: " + cnt);
        }

        return inventory;
    }
}
