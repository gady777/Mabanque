package com.infotel.ig.mabanque.services.impl;

import com.infotel.ig.mabanque.dao.ClientDao;
import com.infotel.ig.mabanque.entities.Client;
import com.infotel.ig.mabanque.services.IClientResource;
import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author HP
 */
public class ClientResource implements IClientResource {
    
    @Autowired
    private ClientDao clientDao;
    
    @Override
    public Page<Client> getAllClients(int page, int pagesize) {
        return clientDao.findAll(PageRequest.of(page, pagesize));
    }
    
    @Override
    public Page<Client> searchClients(String nom, int page, int pagesize) {
        return clientDao.findByNomLikeIgnoreCase("%" + nom + "%", PageRequest.of(page, pagesize));
    }
    
    @Override
    public ResponseEntity<Client> findClient(long id) {
        Optional<Client> client = clientDao.findById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @Override
    public ResponseEntity<Client> updateClient(long id, Client client) {
        /*Optional<Client> oc = clientDao.findById(id);
        if (!oc.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Client c = oc.get();
        c.setAdresse(client.getAdresse());
        c.setNom(client.getNom());
        c.setTelephone(client.getTelephone());
        clientDao.save(c);
        return ResponseEntity.ok(c);*/
        return clientDao.findById(id).map(
                c -> {
                    c.setAdresse(client.getAdresse());
                    c.setNom(client.getNom());
                    c.setTelephone(client.getTelephone());
                    return ResponseEntity.ok(clientDao.save(c));
                }
        ).orElse(
                ResponseEntity.notFound().build()
        );
    }
    
    @Override
    public ResponseEntity<Client> addClient(Client client) {
        Client c = clientDao.save(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);        
    }
    
    @Override
    public void deleteClient(long id) {
        clientDao.deleteById(id);
    }
    
}
