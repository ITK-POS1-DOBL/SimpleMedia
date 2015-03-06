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
 * Backing Bean for search page
 * 
 * @author intruder
 */
@Named(value = "suchenBean")
@RequestScoped
public class SuchenBean {
    
    private String mediumIdString;
    private String mediumTypeString;
    private String mediumTitleString;
    private String mediumDescString;
    private boolean showResult = false;
    private List<MediumDTO> dataTableEntries;
    private MediumDTO dataTableEntry;
    
    @Inject
    private MediaLibrary medLib;

    /** 
     * Default constructor
     * @author Intruder
     */
    public SuchenBean() {
         this.dataTableEntries = new ArrayList<MediumDTO>();
    }

    
    public void findMedium() {
        MediumDTO mediumVals = medLib.findMediumById(convertIdStringToLong(mediumIdString));
        if ((mediumVals != null) && (mediumVals.getMediumIdString().equalsIgnoreCase(mediumIdString))) {
            this.setMediumTypeString(mediumVals.getMediumTypeString());
            this.setMediumTitleString(mediumVals.getMediumTitleString());
            this.setMediumDescString(mediumVals.getMediumDescString());
            this.dataTableEntries.add(mediumVals);
            this.showResult = true;
        }
        else {
            
            resetUserInputs();
        }
    }
    
    public void resetUserInputs() {
        setMediumIdString("0");
        setShowResult(false);
        dataTableEntries.clear();
    }
    
    public String getMediumIdString() {
        return mediumIdString;
    }

    public void setMediumIdString(String mediumIdString) {
        this.mediumIdString = mediumIdString;
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

    public MediumDTO getDataTableEntry() {
        return dataTableEntry;
    }

    public void setDataTableEntry(MediumDTO dataTableEntry) {
        this.dataTableEntry = dataTableEntry;
    }

    
    
    private long convertIdStringToLong(String mediumIdString) {
        return Long.parseLong(mediumIdString);
    }
    
    
    
}
