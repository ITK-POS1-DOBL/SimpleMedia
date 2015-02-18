/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

/**
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
    
    
}
