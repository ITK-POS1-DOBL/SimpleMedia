/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author intruder
 */
public class MediaRepository {
 
    private static List<Medium> mediaList = new ArrayList<>();

    public void add(Medium medium) {
        mediaList.add(medium);
    }

    Medium getMediumById(long Id) {
        
        Medium currentMedium = null;
        
        Iterator iterator = mediaList.iterator();
        while (iterator.hasNext()) {
            currentMedium = (Medium)iterator.next();
            if (Id == currentMedium.getId()) {
                return currentMedium;
            } else {
                currentMedium = null;
            }
        }

        return null;
    }

    List<Medium> getCompleteMediaList() {

        List<Medium> inventory = new ArrayList<>();

        Iterator iterator = mediaList.iterator();
        while (iterator.hasNext()) {
            inventory.add(((Medium)iterator.next()));
            
        }

        return inventory;
    }
}
