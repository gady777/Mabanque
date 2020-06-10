package com.infotel.ig.mabanque.services;

import com.infotel.ig.mabanque.services.impl.ClientResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */
@Component
@ApplicationPath("/api")
public class ApplicationConfig extends ResourceConfig{
    
    public ApplicationConfig(){
        register(ClientResource.class);
    }
}
