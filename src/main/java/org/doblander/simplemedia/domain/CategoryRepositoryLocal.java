/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import javax.ejb.Local;

/**
 *
 * @author intruder
 */
@Local
public interface CategoryRepositoryLocal {

    public Category getCategoryByName(String categoryName);
    
}
