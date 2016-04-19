package org.doblander.simplemedia.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class StartupSSB
 */
@Stateless
@LocalBean
@Startup
public class StartupSSB {

	private AppInitializerBean appInitBean;
	
    /**
     * Default constructor. 
     */
    public StartupSSB() {
        appInitBean = new AppInitializerBean();
    }
    
    @PostConstruct
    public void init() {
    
    	appInitBean.prepareMediaLibForTests();
    }

}
