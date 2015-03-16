/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.doblander.simplemedia.util.SimpleMediaLogger;

/**
 * The media library is the central class for handling all use cases
 * related to handling media and there is exactly one instance in the whole
 * application.
 * 
 * @author intruder
 */
@Singleton
@Startup
//@RunAs("userRole")
public class MediaLibrary {

    //private static final IMediaRepository mediaRepo = new MediaListRepository();
    private static final IMediaRepository mediaRepo = new MediaDBRepository();

    public void insertMedium(String type, String title, String description) {
        Medium tempMedium = new Medium(type, title, description);

        mediaRepo.add(tempMedium);

        // Log-Output for debugging...
        SimpleMediaLogger.logInfo("added medium: " + type + ", " + title
                + ", " + description);
    }

    /**
     * Searches the media store for the medium with the given ID
     *
     * @param Id the value of Id
     * @return the org.doblander.simplemedia.domain.MediumDTO
     */
    public MediumDTO findMediumById(long Id) {

        return mediaRepo.getMediumById(Id).createDTO();

    }

    public List<Medium> getFullInventory() {

        return mediaRepo.getCompleteMediaList();

    }

    public List<MediumDTO> convertMediumListToDTOList(List<Medium> completeMediaList) {

        List<MediumDTO> dtoList = new ArrayList<>();
        Medium tempMedium;

        Iterator iterator = completeMediaList.iterator();
        while (iterator.hasNext()) {
            tempMedium = (Medium) iterator.next();
            dtoList.add(tempMedium.createDTO());
        }

        return dtoList;
    }

    public void updateMedium(MediumDTO mediumDto) {
        mediaRepo.updateMedium(mediumDto);
    }

    public void deleteItemById(Long mediumId) {
        mediaRepo.deleteMediumById(mediumId);
    }
    
    @PostConstruct
    private void initializeMediaLib() {
        insertMedium("cd", "cd1", "a cd");
        insertMedium("dvd", "dvd1", "a dvd");
        insertMedium("cd", "cd2", "another cd");
        insertMedium("bd", "bd1", "a bd");
        insertMedium("minidisk", "minidisk1", "an ancient medium");
    }
}
