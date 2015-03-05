/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author intruder
 */
public class MediaRepository {
 
    private static ArrayList<Medium> mediaList = new ArrayList();

    private static HashMap mediaStore = new HashMap();

    public void add(Medium medium) {
        mediaList.add(medium);
    }

    MediumDTO getMediumById(long Id) {
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

    ArrayList<MediumDTO> getCompleteMediaList() {
        ArrayList<MediumDTO> inventory = new ArrayList<MediumDTO>();

        int cnt = 1;
        Iterator iterator = mediaList.iterator();
        //while (mediaList.iterator().hasNext()) {
        //MediumVO mediumval = ((Medium)iterator.next()).createVO();
        while (iterator.hasNext()) {
            inventory.add(((Medium)iterator.next()).createVO());
            
        }

        return inventory;
    }
}
