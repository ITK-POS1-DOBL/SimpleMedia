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
public class CategoryDTO {
    
    private String idString;
    private String textString;
    
    public CategoryDTO() {
        this.idString = "";
        this.textString = "";
    }
    
    public CategoryDTO(long Id, String text) {
        this.idString = Long.toString(Id);
        this.textString = text;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

    public String getTextString() {
        return textString;
    }

    public void setTextString(String textString) {
        this.textString = textString;
    }
    
    
     
}
