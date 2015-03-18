/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.admin;

import java.util.List;
import javax.ejb.Local;
import org.doblander.simplemedia.domain.Category;
import org.doblander.simplemedia.domain.CategoryDTO;

/**
 *
 * @author intruder
 */
@Local
public interface SimpleMediaAppAdminLocal {

    /**
     *
     * @param catName the value of catName
     */
    void add(String catName);
    
    
    /**
     * Finds a medium identified by its ID in the library
     *
     * @param Id The ID of the medium to be retrieve from the library
     * @return A single medium object is returned when a matching ID is found in
     * the library, otherwise null is returned.
     */
    Category getCategoryById(long Id);

    /**
     * A list of all available media categories is returned.
     *
     * @return A list of category objects
     */
    List<Category> getCompleteCategoryList();

    /**
     * A category identified as a corresponding DTO object is updated with data
     * held in that DTO object.
     *
     * @param categoryDto The DTO object that identifies the medium to be updated
     * (=ID field) and holds the all medium fields that are then written back to
     * the original object in the library.
     */
    public void updateMedium(CategoryDTO categoryDto);

    /**
     * Delete a medium identified by its ID
     *
     * @param categoryId The ID of the medium object that is to be deleted from
     * the library.
     */
    public void deleteCategoryById(Long categoryId);

    /**
     * Indicates whether the category store has been initialized with some
     * values. The number of categories in the library has to exceed a hardcoded
     * threshold (currently set to 5). This function is more or less only useful
     * as a convenience function during development.
     *
     * @return TRUE if number of categories in library exceeds threshold, FALSE
     * otherwise
     */
    public boolean isInitializedWithData();

    public List<CategoryDTO> convertCategoryListToDTOList(List<Category> completeCategoryList);

    
}
