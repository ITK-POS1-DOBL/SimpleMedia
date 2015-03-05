/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.util;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author intruder
 */
public class SimpleMediaLogger {
    
    private static final Logger smlogger
            = Logger.getLogger("org.doblander.simplemedia.domain.MediaLibrary");
    
    public static void logInfo(String infoText) {
        smlogger.log(Level.INFO, infoText);
    }
}
