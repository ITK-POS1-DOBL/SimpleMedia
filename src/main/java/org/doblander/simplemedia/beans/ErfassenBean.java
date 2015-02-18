/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.doblander.simplemedia.domain.MediaLibrary;


/**
 *
 * @author intruder
 */
@Named(value = "erfassenBean")
@RequestScoped
public class ErfassenBean {

    private String type;
    private String title;
    private String description;
    
    @Inject
    private MediaLibrary theLib;
    
    /**
     * Creates a new instance of ErfassenBean
     */
    public ErfassenBean() {
    }

    public void saveMedium() {
        theLib.insertMedium(type, title, description);
        resetUserInputs();
        
    }
    
    public void resetUserInputs() {
        setType("");
        setTitle("");
        setDescription("");
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
