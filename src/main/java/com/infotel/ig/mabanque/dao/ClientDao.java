package com.infotel.ig.mabanque.dao;

import com.infotel.ig.mabanque.entities.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface ClientDao extends JpaRepository<Client, Long>{
    
    public List<Client> findByNomLike(String nom);
    
}
