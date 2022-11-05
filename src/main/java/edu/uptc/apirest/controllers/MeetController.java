package edu.uptc.apirest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uptc.apirest.entities.Act;
import edu.uptc.apirest.entities.Meet;
import edu.uptc.apirest.entities.Room;
import edu.uptc.apirest.services.MeetService;


@RestController
@RequestMapping("/meets")
@CrossOrigin(origins = "https://front-taller-electiva2.vercel.app/")
public class MeetController {

    @Autowired
    private MeetService meetService;

    public MeetController(MeetService meetService){
        this.meetService = meetService;
    }

    @GetMapping
    public List<Meet> getMeet(){
        ArrayList<Meet> lista=(ArrayList<Meet>) meetService.getMeets();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getAct() == null){
                lista.get(i).setAct(new Act());
            }
            if(lista.get(i).getRoom() == null){
                lista.get(i).setRoom(new Room());
            }
        }
        return lista;
    }

    @GetMapping("/{id}")
    public Meet findById(@PathVariable int id){
        return meetService.findById(id);
    }

    @PostMapping
    public Meet save(@RequestBody Meet meet){
        return meetService.save(meet);
    }

    @PutMapping("/{id}")
    public Meet update(@RequestBody Meet meet, @PathVariable int id){
        return meetService.update(meet);
    }

    @DeleteMapping("/{id}")
    public Meet delete(@PathVariable("id") int id){
        return meetService.delete(id);
    }
    
}
