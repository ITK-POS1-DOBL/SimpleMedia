/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.doblander.simplemedia.domain.MediaLibrary;
import org.doblander.simplemedia.domain.MediumDTO;

/**
 * Backing bean for deletion page
 * 
 * @author intruder
 */
@Named(value = "loeschenBean")
@RequestScoped
public class LoeschenBean {

    private String mediumIdString;
    private boolean showResult = false;
    
    private List<MediumDTO> mediaList;

    @Inject
    private MediaLibrary mediaLib;
    
    /**
     * Creates a new instance of LoeschenBean
     */
    public LoeschenBean() {
    }
    
    public void deleteMedium() {
        
        retrieveInventory();
    }
    
    public void retrieveInventory() {
        this.setMediaList(mediaLib.convertMediumListToDTOList(
                        mediaLib.getFullInventory()));
        this.setShowResult(true);
    }
    
    public void resetResults() {
        setShowResult(false);
        mediaList = null;
    }

    public String getMediumIdString() {
        return mediumIdString;
    }

    public void setMediumIdString(String mediumIdString) {
        this.mediumIdString = mediumIdString;
    }
    
    
    public boolean isShowResult() {
        return showResult;
    }

    public void setShowResult(boolean showResult) {
        this.showResult = showResult;
    }

    public List<MediumDTO> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<MediumDTO> mediaList) {
        this.mediaList = mediaList;
    }

}
