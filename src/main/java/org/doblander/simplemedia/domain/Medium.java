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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private long id;
    
    @ManyToOne
    private Category category;
    private String title;
    private String description;

    public Medium() {
    }

    public Medium(String categoryText, String title, String description) {
        this.category.setCategoryText(categoryText);
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
        return new MediumDTO(this.id, this.category.getCategoryText(), this.title, this.description);
    }

}
