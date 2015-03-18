/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.doblander.simplemedia.admin.SimpleMediaAppAdminLocal;
import org.doblander.simplemedia.domain.CategoryDTO;

/**
 *
 * @author intruder
 */
@Named(value = "adminBean")
@RequestScoped
public class adminBean {

    private boolean showResult = false;

    private List<CategoryDTO> catList;

    @EJB
    private SimpleMediaAppAdminLocal appAdmin;

    /**
     * Creates a new instance of adminBean
     */
    public adminBean() {
    }
    
    public void resetResults() {
        setShowResult(false);
        catList.clear();
    }

    public void retrieveCategories() {
        this.setCatList(appAdmin.convertCategoryListToDTOList(
                appAdmin.getCompleteCategoryList()));
        this.setShowResult(true);
    }
    
    public boolean isShowResult() {
        return showResult;
    }

    public void setShowResult(boolean showResult) {
        this.showResult = showResult;
    }

    public List<CategoryDTO> getCatList() {
        return catList;
    }

    public void setCatList(List<CategoryDTO> catList) {
        this.catList = catList;
    }
    
}
