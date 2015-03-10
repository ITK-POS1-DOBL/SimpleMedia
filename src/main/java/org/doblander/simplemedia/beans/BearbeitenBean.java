/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.doblander.simplemedia.domain.MediaLibrary;
import org.doblander.simplemedia.domain.MediumDTO;
import org.doblander.simplemedia.util.SimpleMediaLogger;

/**
 *
 * @author intruder
 */
@Named(value = "bearbeitenBean")
@SessionScoped
public class BearbeitenBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String mediumIdString;
    private String mediumTypeString;
    private String mediumTitleString;
    private String mediumDescString;

    private boolean showResult = false;

    private List<MediumDTO> dataTableEntries;

    @Inject
    private MediaLibrary medLib;

    /**
     * Creates a new instance of BearbeitenBean
     */
    public BearbeitenBean() {
        this.dataTableEntries = new ArrayList<>();
    }

    public void findMedium() {
        resetUserInputs();
        MediumDTO mediumVals = medLib.findMediumById(convertIdStringToLong(mediumIdString));
        if ((mediumVals != null) && (mediumVals.getMediumIdString().equalsIgnoreCase(mediumIdString))) {
            this.dataTableEntries.add(mediumVals);
            this.showResult = true;
        } else {

            resetUserInputs();
        }
    }

    public void resetUserInputs() {
        //setMediumIdString("0");
        setShowResult(false);
        dataTableEntries.clear();
    }

    public void updateMedium() {
        // safe all changes made by the user to the media lib (repository)
        
        if (dataTableEntries.size() == 1) {
            MediumDTO medDto = new MediumDTO();        
            medDto = dataTableEntries.get(0);
            medLib.updateMedium(medDto);
            SimpleMediaLogger.logInfo("Updating medium to: " + medDto.getMediumTypeString());
        }
        else {
            SimpleMediaLogger.logSevere("Search result was ambiguous!");
        }        
    }

    public void resetUpdate() {
        resetUserInputs();
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

    public List<MediumDTO> getDataTableEntries() {
        return dataTableEntries;
    }

    public void setDataTableEntries(List<MediumDTO> dataTableEntries) {
        this.dataTableEntries = dataTableEntries;
    }

    public String getMediumTypeString() {
        return mediumTypeString;
    }

    public void setMediumTypeString(String mediumTypeString) {
        this.mediumTypeString = mediumTypeString;
    }

    public String getMediumTitleString() {
        return mediumTitleString;
    }

    public void setMediumTitleString(String mediumTitleString) {
        this.mediumTitleString = mediumTitleString;
    }

    public String getMediumDescString() {
        return mediumDescString;
    }

    public void setMediumDescString(String mediumDescString) {
        this.mediumDescString = mediumDescString;
    }

    private long convertIdStringToLong(String mediumIdString) {
        return Long.parseLong(mediumIdString);
    }

}
