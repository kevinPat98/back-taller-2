package edu.uptc.apirest.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "meets")
@Getter @Setter
@AllArgsConstructor
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(nullable = false, length = 255)
    private String affair;

    @Column(name = "date_meet", nullable = false)
    private LocalDateTime dateMeet;

    @OneToOne(mappedBy = "meet") 
    @JsonIgnoreProperties("meet")
    private Act act;

   // @ManyToOne( fetch = FetchType.LAZY )
   @ManyToOne
   @JoinColumn(name="room_id")
   @JsonIgnoreProperties("meets")
   private Room room;

    public Meet() {
    }

    public Meet(String affair, LocalDateTime dateMeet, Room room) {
        this.affair = affair;
        this.dateMeet = dateMeet;
        this.room = room;
        room.addMeet( this );
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAffair() {
        return affair;
    }

    public void setAffair(String affair) {
        this.affair = affair;
    }

    public LocalDateTime getDateMeet() {
        return dateMeet;
    }

    public void setDateMeet(LocalDateTime dateMeet) {
        this.dateMeet = dateMeet;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
