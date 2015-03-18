/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.List;
import javax.ejb.Local;

/**
 * Interface type for media repositories. Used to abstract from a concrete
 * repository implementation so that it can be changed easily in the future.
 *
 * @author intruder
 */
@Local
public interface IMediaRepository {

    /**
     * A single medium object is stored in the media library
     *
     * @param medium The medium object that is added to the media library store
     */
    void add(Medium medium);

    /**
     * Finds a medium identified by its ID in the library
     *
     * @param Id The ID of the medium to be retrieve from the library
     * @return A single medium object is returned when a matching ID is found in
     * the library, otherwise null is returned.
     */
    Medium getMediumById(long Id);

    /**
     * A list of all media managed in the library is returned.
     *
     * @return A list of medium objects
     */
    List<Medium> getCompleteMediaList();

    /**
     * A medium identified as a corresponding DTO object is updated with data
     * held in that DTO object.
     *
     * @param mediumDto The DTO object that identifies the medium to be updated
     * (=ID field) and holds the all medium fields that are then written back to
     * the original object in the library.
     */
    public void updateMedium(MediumDTO mediumDto);

    /**
     * Delete a medium identified by its ID
     *
     * @param mediumId The ID of the medium object that is to be deleted from
     * the library.
     */
    public void deleteMediumById(Long mediumId);

    /**
     * Indicates whether the library store has been initialized with some
     * values. The number of media in the library has to exceed a hardcoded
     * threshold (currently set to 5). This function is more or less only useful
     * as a convenience function during development.
     *
     * @return TRUE if number of media in library exceeds threshold, FALSE
     * otherwise
     */
    public boolean isInitializedWithData();

}
