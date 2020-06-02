
package com.infotel.ig.mabanque.dao;

import com.infotel.ig.mabanque.entities.Compte;
import com.infotel.ig.mabanque.entities.Operation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface OperationDao extends JpaRepository<Operation, Long>{
    
    public List<Operation> findByDateOperation(Date dateOperation);
    
    public List<Operation> findByDateOperationBetween(Date date1, Date date2);
    public List<Operation> findByCompte(Compte compte);
    public List<Operation> findByCompteAndDateOperation(Compte compte, Date dateOperation);
    public List<Operation> findByCompteAndDateOperationBetween(Compte compte, Date date1, Date date2);
    
}
