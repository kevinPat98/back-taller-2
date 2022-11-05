package edu.uptc.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uptc.apirest.entities.Meet;

@Repository
public interface MeetRepository  extends JpaRepository<Meet, Integer>{
    
}
