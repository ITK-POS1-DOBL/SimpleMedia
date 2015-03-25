/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.util;

import javax.annotation.PostConstruct;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.doblander.simplemedia.admin.SimpleMediaAppAdminLocal;
import org.doblander.simplemedia.domain.IMediaRepository;
import org.doblander.simplemedia.domain.MediaLibrary;

/**
 *
 * @author intruder
 */
@Singleton
@Startup
@RunAs("admin")
public class AppInitializerBean {

    @EJB
    private IMediaRepository mediaRepo;
    
    @EJB
    private MediaLibrary mediaLib;
    
    @EJB
    private SimpleMediaAppAdminLocal adminService;
    
    @PostConstruct
    private void prepareMediaLibForTests() {
        /* DB is already initialized so no more initialization code needed
         * at the moment!
         */

        if (!mediaRepo.isInitializedWithData()) {
            mediaLib.insertMedium("cd", "cd1", "a cd");
            mediaLib.insertMedium("dvd", "dvd1", "a dvd");
            mediaLib.insertMedium("cd", "cd2", "another cd");
            mediaLib.insertMedium("bd", "bd1", "a bd");
            mediaLib.insertMedium("minidisk", "minidisk1", "an ancient medium");
        }
        
        if (!adminService.isInitializedWithData()) {
            mediaLib.insertCategory("CD");
            mediaLib.insertCategory("DVD");
            mediaLib.insertCategory("BD");
            mediaLib.insertCategory("MD");
            mediaLib.insertCategory("FD");
        }
        
    }
}
