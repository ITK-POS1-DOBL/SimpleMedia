/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.doblander.simplemedia.domain.MediaLibrary;
import org.doblander.simplemedia.domain.MediumDTO;

/**
 *
 * @author intruder
 */
@Named(value = "inventarBean")
@RequestScoped
public class InventarBean {

    private boolean showResult = false;
    
    private List<MediumDTO> mediaList;

    @Inject
    private MediaLibrary mediaLib;

    /**
     * Default constructor
     *
     * @author Intruder
     */
    public InventarBean() {
        this.mediaList = new ArrayList<>();
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
