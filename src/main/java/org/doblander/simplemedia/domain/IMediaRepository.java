/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.List;

/**
 *
 * @author intruder
 */
public interface IMediaRepository {

    void add(Medium medium);
    
    Medium getMediumById(long Id);
    
    List<Medium> getCompleteMediaList();
    
}
