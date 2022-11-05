package edu.uptc.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.apirest.entities.Act;
import edu.uptc.apirest.repositories.ActRepository;


@Service
public class ActService {

    @Autowired
    private ActRepository actRepository;

    MeetService meetService;



    public ActService(ActRepository actRepository, MeetService meetServicio) {
        this.actRepository = actRepository;
        this.meetService = meetServicio;
    }

    public List<Act> getActs(){

        return actRepository.findAll();
    }
  //Si es la primera vez, agreguelo
    /*PENDIENTE Validar cuando esta vacio [Para que no se dañe] */
    public Act save( Act act){

      Integer id_meet=  act.getMeet().getId();
      if(!meetService.haveAct(id_meet)){ //validar que ese  meet no tenga una acta ya creada
        return actRepository.save(act);
      }else{
        return act;
      }
      
    }


    
   /*  public Act save( Act act){
        return actRepository.save(act);
    }*/

    public Act findById(int id){

        Optional<Act> optAct = actRepository.findById(id);

        return optAct.isPresent() ? optAct.get() : null;
    }

    // public Act update(Act act){

    //     if(act.getId()!=null){
    //         Optional<Act> e = actRepository.findById(act.getId());
    //         if(!e.isEmpty()){
    //             if(act.getDescription()!=null){
    //                 e.get().setDescription(act.getDescription());
    //             }
    //             if(act.getMeet()!=null){
    //                 e.get().setMeet(act.getMeet());
    //             }
    //             actRepository.save(e.get());
    //             return e.get();
    //         }else{
    //             return act;
    //         }
    //     }else{
    //         return act;
    //     }
    // }

   public Act update(Act act){

        if( findById( act.getId()) !=  null ){
            return actRepository.save( act );
        }

        return null;
    }

    public Act delete(int id) {
        Act act = findById( id );
        if( act != null){
            actRepository.delete( act );
        }

        return act;
    }

    
}
