/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

/**
 * A Medium is the central domain object and stores information of a 
 * concrete medium.
 * 
 * @author intruder
 */
public class Medium {

    private long Id;
    private String type;
    private String title;
    private String description;

    private static long idCounter = 0;

    public Medium() {
    }

    public Medium(String type, String title, String description) {
        this.Id = getNextId();
        this.type = type;
        this.title = title;
        this.description = description;
    }

    private long getNextId() {
        return idCounter++;
    }

    public long getId() {
        return Id;
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

    MediumDTO createDTO() {
        return new MediumDTO(this.Id, this.type, this.title, this.description);
    }

    
}
