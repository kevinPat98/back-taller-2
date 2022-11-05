package edu.uptc.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uptc.apirest.entities.Meet;
import edu.uptc.apirest.services.MeetService;


@RestController
@RequestMapping("/meets")
public class MeetController {

    @Autowired
    private MeetService meetService;

    public MeetController(MeetService meetService){
        this.meetService = meetService;
    }

    @GetMapping
    public List<Meet> getMeet(){
        return meetService.getMeets();
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
