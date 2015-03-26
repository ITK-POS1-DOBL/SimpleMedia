/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.List;
import javax.ejb.Local;

/**
 * Interface type for media repositories. 
 * Used to abstract from a concrete repository implementation so that it can be changed easily in the future.
 *
 * @author intruder
 */
@Local
public interface IMediaRepository {

    void add(Medium medium);

    Medium getMediumById(long Id);

    List<Medium> getCompleteMediaList();

    public void updateMedium(MediumDTO mediumDto);

    public void deleteMediumById(Long mediumId);

}
