/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * A Medium is the central domain object and stores information of a concrete
 * medium.
 *
 * @author intruder
 */
@Entity
public class Medium implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    private long Id;
    private String category;
    private String title;
    private String description;

    public Medium() {
    }

    public Medium(String category, String title, String description) {
        this.category = category;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return Id;
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

    MediumDTO createDTO() {
        return new MediumDTO(this.Id, this.category, this.title, this.description);
    }

}
