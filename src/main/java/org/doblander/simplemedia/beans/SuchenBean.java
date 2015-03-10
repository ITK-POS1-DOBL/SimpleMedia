/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
    private boolean showResult = false;
    private List<MediumDTO> dataTableEntries;
    private MediumDTO dataTableEntry;
    
    @EJB
    private MediaLibrary medLib;

    /** 
     * Default constructor
     * @author Intruder
     */
    public SuchenBean() {
         this.dataTableEntries = new ArrayList<>();
    }

    
    public void findMedium() {
        MediumDTO mediumVals = medLib.findMediumById(convertIdStringToLong(mediumIdString));
        if ((mediumVals != null) && (mediumVals.getMediumIdString().equalsIgnoreCase(mediumIdString))) {
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
