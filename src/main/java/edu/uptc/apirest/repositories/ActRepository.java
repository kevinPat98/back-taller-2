package edu.uptc.apirest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uptc.apirest.entities.Act;

@Repository
public interface ActRepository  extends JpaRepository<Act, Integer>{
    
}
