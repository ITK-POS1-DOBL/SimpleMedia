/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.doblander.simplemedia.admin.SimpleMediaAppAdminLocal;
import org.doblander.simplemedia.util.SimpleMediaLogger;
import org.doblander.simplemedia.exception.CategoryNotFoundException;

/**
 * The media library is the central class for handling all use cases related to
 * handling media and there is exactly one instance in the whole application.
 *
 * @author intruder
 */
@Stateless
public class MediaLibrary {

    //private static final IMediaRepository mediaRepo = new MediaListRepository();
    @EJB
    private IMediaRepository mediaRepo;
    
    @EJB
    private CategoryRepositoryLocal catRepo;
    
    @EJB
    private SimpleMediaAppAdminLocal appAdmin;

    public void insertMedium(String categoryName, String title, String description) throws CategoryNotFoundException {
        
        try {
            Category category = catRepo.getCategoryByName(categoryName);

            Medium tempMedium = new Medium(category, title, description);

            mediaRepo.add(tempMedium);

            // Log-Output for debugging...
            SimpleMediaLogger.logInfo("added medium: " + category + ", " + title
                    + ", " + description);
        }
        catch (Exception e) {
            throw new CategoryNotFoundException("Category " + categoryName + "not found!");
        }
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

        Iterator<Medium> iterator = completeMediaList.iterator();
        while (iterator.hasNext()) {
            tempMedium = iterator.next();
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

    

    public void insertCategory(String cd) {
        appAdmin.add(cd);
    }
}
