/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotel.ig.mabanque.dao;

import com.infotel.ig.mabanque.entities.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface CompteCourantDao extends JpaRepository<CompteCourant, Long>{
    
}
