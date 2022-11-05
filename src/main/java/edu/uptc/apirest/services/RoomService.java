package edu.uptc.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.apirest.entities.Room;
import edu.uptc.apirest.repositories.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository= roomRepository;
    }

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    public Room save(Room room){
        return roomRepository.save(room);

    }

    public Room findById(int id){
        Optional <Room> optRoom= roomRepository.findById(id);
        return optRoom.isPresent() ? optRoom.get() : null;
    }

    public Room update (Room room){
        if(findById(room.getId())!= null){
            return roomRepository.save(room);
        }

        return null;
       
    }

    public Room delete (int id){
        Room room = findById(id);
        if(room !=null){
            roomRepository.delete(room);
        }
        return room;
    }

    
}
