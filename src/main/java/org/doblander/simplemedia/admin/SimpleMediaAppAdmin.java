/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.doblander.simplemedia.domain.Category;
import org.doblander.simplemedia.domain.CategoryDTO;

/**
 * Administration functions for the SimpleMedia application
 *
 * @author intruder
 */
@Stateless
@DeclareRoles("admin")
public class SimpleMediaAppAdmin implements SimpleMediaAppAdminLocal {
    
    @PersistenceContext
    private EntityManager em;

    /**
     *
     * @param catName the value of catName
     */
    @Override
    public void add(String catName) {
        Category cat = new Category();
        cat.setCategoryText(catName);
        em.persist(cat);
    }
    
    @Override
    public Category getCategoryById(long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Category> getCompleteCategoryList() {
        return em.createQuery("SELECT c FROM Category c").getResultList();
    }
    
    @Override
    public void updateMedium(CategoryDTO categoryDto) {
        Category cat = em.find(Category.class, Long.valueOf(categoryDto.getIdString()));
        cat.setCategoryText(categoryDto.getTextString());
        em.flush();
    }
    
    @Override
    public void deleteCategoryById(Long categoryId) {
        em.remove(getCategoryById(categoryId));
    }
    
    @Override
    public boolean isInitializedWithData() {
        return (getCompleteCategoryList().size() >= 5);
    }
    
    @Override
    public List<CategoryDTO> convertCategoryListToDTOList(List<Category> completeCategoryList) {
        List<CategoryDTO> dtoList = new ArrayList<>();
        Category tempCategory;
        
        Iterator<Category> iterator = completeCategoryList.iterator();
        while (iterator.hasNext()) {
            tempCategory = iterator.next();
            dtoList.add(tempCategory.createDTO());
        }
        
        return dtoList;
    }
    
}
