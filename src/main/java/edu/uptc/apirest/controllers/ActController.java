package edu.uptc.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uptc.apirest.entities.Act;
import edu.uptc.apirest.services.ActService;


@RestController
@RequestMapping("/acts")
public class ActController {

    @Autowired
    ActService actService;

    public ActController(ActService roomService) {
        this.actService = roomService;
    }

    @GetMapping
    public Iterable <Act> get(){
        return actService.getActs();
    }

    @GetMapping("/{id}")
    public Act findById(@PathVariable int id){
        return actService.findById(id);
    }

    @PostMapping
    public Act save(@RequestBody Act act){

        return actService.save(act);
    }

    @PutMapping("/{id}")
    public Act update(@RequestBody Act act, @PathVariable int id){
        return actService.update(act);
    }

    @DeleteMapping("/{id}")
    public Act delete(@PathVariable("id") int id){
        return actService.delete(id);
    }
    
}
