
package com.infotel.ig.mabanque.dao;

import com.infotel.ig.mabanque.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface UtilisateurDao  extends JpaRepository<Utilisateur, Long>{
    
}
