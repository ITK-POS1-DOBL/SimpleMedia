/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author intruder
 */
@Named(value = "suchenBean")
@RequestScoped
public class SuchenBean {

    private String mediumId;

    public void findMedium() {
        
    }
    
    public void resetUserInputs() {
        setMediumId("");
    }
    
    public String getMediumId() {
        return mediumId;
    }

    public void setMediumId(String mediumId) {
        this.mediumId = mediumId;
    }
    
    
}
