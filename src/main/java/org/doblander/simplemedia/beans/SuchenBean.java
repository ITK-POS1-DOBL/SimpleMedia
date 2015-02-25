/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.doblander.simplemedia.domain.MediaLibrary;
import org.doblander.simplemedia.domain.MediumVO;

/**
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
    
    @Inject
    private MediaLibrary medLib;

    public void findMedium() {
        MediumVO mediumVals = medLib.findMediumById(convertIdStringToLong(mediumIdString));
        if ((mediumVals != null) && (mediumVals.getMediumIdString().equalsIgnoreCase(mediumIdString))) {
            this.setMediumTypeString(mediumVals.getMediumTypeString());
            this.setMediumTitleString(mediumVals.getMediumTitleString());
            this.setMediumDescString(mediumVals.getMediumDescString());
            this.showResult = true;
        }
        else {
            // an error occurred!
        }
    }
    
    public void resetUserInputs() {
        setMediumIdString("");
        setShowResult(false);
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

    private long convertIdStringToLong(String mediumIdString) {
        return Long.parseLong(mediumIdString);
    }
    
    
    
}
