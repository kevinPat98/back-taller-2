package edu.uptc.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uptc.apirest.entities.Room;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Integer>{
    
}
