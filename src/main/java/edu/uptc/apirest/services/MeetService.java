package edu.uptc.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.apirest.entities.Meet;
import edu.uptc.apirest.repositories.MeetRepository;

@Service
public class MeetService {

    @Autowired
    private MeetRepository meetRepository;

    public MeetService(MeetRepository meetRepository){
        this.meetRepository= meetRepository;
    }

    public List<Meet> getMeets(){
        return meetRepository.findAll();
    }

    public Meet save(Meet meet){
        return meetRepository.save(meet);
    }

    public Meet findById(int id){
        Optional <Meet> optMeet= meetRepository.findById(id);
        return optMeet.isPresent() ? optMeet.get() : null;
    }

    public Meet update (Meet meet){

        if(meet.getId()!=null){
            Meet e = meetRepository.findById(meet.getId()).get();
            if(e != null){
                if(meet.getAffair()!=null){
                    e.setAffair(meet.getAffair());
                }
                if(meet.getDateMeet()!=null){
                    e.setDateMeet(meet.getDateMeet());
                }
                if(meet.getAct()!=null){
                    e.setAct(meet.getAct());
                }
                if(meet.getRoom()!=null){
                    e.setRoom(meet.getRoom());
                }
                meetRepository.save(e);
                return e;
                
            }else{
                return meet;
            }
        }else{
            return meet;
        }

    }

 /*  public Meet update (Meet meet){
        if(findById(meet.getId())!= null){
            return meetRepository.save(meet);
        }

        return null;
       
    } */

    public Meet delete (int id){
        Meet meet = findById(id);
        if(meet !=null){
            meetRepository.delete(meet);
        }
        return meet;
    }

    public Boolean haveAct(int id){
        Meet meet = findById(id);
        if(meet.getAct()!=null){
            return true;
        }
        return false;
    }

    
}
