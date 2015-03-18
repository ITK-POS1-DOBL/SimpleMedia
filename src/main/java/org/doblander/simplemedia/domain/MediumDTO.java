/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

/**
 * Type for value objects of medium objects for communication between business
 * domain and UI
 *
 * @author intruder
 */
public class MediumDTO {

    private String mediumIdString;
    private String mediumCategoryString;
    private String mediumTitleString;
    private String mediumDescString;

    public MediumDTO() {
        this.mediumIdString = "";
        this.mediumCategoryString = "";
        this.mediumTitleString = "";
        this.mediumDescString = "";
    }

    public MediumDTO(long Id, String type, String title, String description) {
        this.mediumIdString = Long.toString(Id);
        this.mediumCategoryString = type;
        this.mediumTitleString = title;
        this.mediumDescString = description;

    }

    public String getMediumIdString() {
        return mediumIdString;
    }

    public void setMediumIdString(String mediumIdString) {
        this.mediumIdString = mediumIdString;
    }

    public String getMediumCategoryString() {
        return mediumCategoryString;
    }

    public void setMediumCategoryString(String mediumCategoryString) {
        this.mediumCategoryString = mediumCategoryString;
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

}
