/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author intruder
 */
@Stateless
public class CategoryRepository implements CategoryRepositoryLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public Category getCategoryByName(String categoryName) {
        String queryString = "SELECT c FROM Category c WHERE c.categoryText LIKE " + "'"+ categoryName + "'";
        return (Category)em.createQuery(queryString).getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
