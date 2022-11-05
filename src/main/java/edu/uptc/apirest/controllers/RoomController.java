package edu.uptc.apirest.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uptc.apirest.entities.Room;
import edu.uptc.apirest.services.RoomService;

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "http://localhost:4200/")
public class RoomController {

    @Autowired
    private RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping
    public Iterable<Room> getRoom(){
        return roomService.getRooms();
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable int id){
        return roomService.findById(id);
    }

    @PostMapping
    public Room save(@RequestBody Room room){
        return roomService.save(room);
    }

    @PutMapping("/{id}")
    public Room update(@RequestBody Room room, @PathVariable int id){
        return roomService.update(room);
    }

    @DeleteMapping("/{id}")
    public Room delete(@PathVariable("id") int id){
        return roomService.delete(id);
    }
    
}
