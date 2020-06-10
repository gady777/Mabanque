package com.infotel.ig.mabanque.services;

import com.infotel.ig.mabanque.entities.Client;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP
 */
@Path("/clients")
public interface IClientResource {
    
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Page<Client> getAllClients(@DefaultValue("0") @QueryParam("page")int page, @DefaultValue("20") @QueryParam("size")int pagesize);
    
    
    @GET
    @Path("/search")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Page<Client> searchClients(@QueryParam("nom")String nom, @DefaultValue("0") @QueryParam("page")int page, @DefaultValue("20") @QueryParam("size")int pagesize);
    
    @GET
    @Path("{id: \\d+}")
    @Produces(value ={MediaType.APPLICATION_JSON})
    public ResponseEntity<Client> findClient(@PathParam("id") long id);
    
    
    @PUT
    @Path("{id: \\d+}")
    @Produces(value ={MediaType.APPLICATION_JSON})
    @Consumes(value ={MediaType.APPLICATION_JSON})
    public ResponseEntity<Client> updateClient(@PathParam("id") long id, Client client);
    
    
    @POST
    @Produces(value ={MediaType.APPLICATION_JSON})
    @Consumes(value ={MediaType.APPLICATION_JSON})
    public ResponseEntity<Client> addClient(Client client);
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteClient(@PathParam("id") long id);
    
}
