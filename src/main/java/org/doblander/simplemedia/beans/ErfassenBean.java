/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.doblander.simplemedia.domain.MediaLibrary;

/**
 * Backing bean for media entry page
 * 
 * @author intruder
 */
@Named(value = "erfassenBean")
@RequestScoped
public class ErfassenBean {

    private String category;
    private String title;
    private String description;

    @EJB
    private MediaLibrary theLib;

    /**
     * Creates a new instance of ErfassenBean
     */
    public ErfassenBean() {
    }

    public void saveMedium() {
        theLib.insertMedium(category, title, description);
        resetUserInputs();

    }

    public void resetUserInputs() {
        setCategory("");
        setTitle("");
        setDescription("");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
