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
import org.doblander.simplemedia.domain.MediumVO;

/**
 * Backing Bean for "suchen.xhtml"
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
    private List<MediumVO> dataTableEntries;
    private MediumVO dataTableEntry;
    
    @Inject
    private MediaLibrary medLib;

    /** 
     * Default constructor
     * @author Intruder
     */
    public SuchenBean() {
         this.dataTableEntries = new ArrayList<MediumVO>();
    }

    
    public void findMedium() {
        MediumVO mediumVals = medLib.findMediumById(convertIdStringToLong(mediumIdString));
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

    public List<MediumVO> getDataTableEntries() {
        return dataTableEntries;
    }

    public void setDataTableEntries(List<MediumVO> dataTableEntries) {
        this.dataTableEntries = dataTableEntries;
    }

    public MediumVO getDataTableEntry() {
        return dataTableEntry;
    }

    public void setDataTableEntry(MediumVO dataTableEntry) {
        this.dataTableEntry = dataTableEntry;
    }

    
    
    private long convertIdStringToLong(String mediumIdString) {
        return Long.parseLong(mediumIdString);
    }
    
    
    
}
