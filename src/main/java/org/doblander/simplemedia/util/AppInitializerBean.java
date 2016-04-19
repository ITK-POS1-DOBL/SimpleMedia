/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import org.doblander.simplemedia.admin.SimpleMediaAppAdminLocal;
import org.doblander.simplemedia.domain.IMediaRepository;
import org.doblander.simplemedia.domain.MediaLibrary;
import org.doblander.simplemedia.exception.CategoryNotFoundException;

/**
 *
 * @author intruder
 */
@Singleton
@RunAs("admin")
public class AppInitializerBean {

    @EJB
    private IMediaRepository mediaRepo;
    
    @EJB
    private MediaLibrary mediaLib;
    
    @EJB
    private SimpleMediaAppAdminLocal adminService;
    
    public void prepareMediaLibForTests() {

    	/* DB is already initialized so no more initialization code needed
         * at the moment!
         */
        if (!adminService.isInitializedWithData()) {
            mediaLib.insertCategory("CD");
            mediaLib.insertCategory("DVD");
            mediaLib.insertCategory("BD");
            mediaLib.insertCategory("MD");
            mediaLib.insertCategory("FD");
        }
        
        if (!mediaRepo.isInitializedWithData()) {
            try {
                mediaLib.insertMedium("cd", "cd1", "a cd");
                mediaLib.insertMedium("dvd", "dvd1", "a dvd");
                mediaLib.insertMedium("cd", "cd2", "another cd");
                mediaLib.insertMedium("bd", "bd1", "a bd");
                mediaLib.insertMedium("minidisk", "minidisk1", "an ancient medium");
            } catch (CategoryNotFoundException ex) {
                Logger.getLogger(AppInitializerBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
