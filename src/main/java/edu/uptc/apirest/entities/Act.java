package edu.uptc.apirest.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "acts")
@Getter @Setter
@AllArgsConstructor
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column
    private String description;

    @OneToOne
    @JoinColumn(name="meet_id")
    //@JsonIgnoreProperties({"room", "act"})
    private Meet meet;


    public Act() {
    }

    public Act(String description, Meet meet ) {
        this.description = description;
        this.meet = meet;
        meet.setAct( this );
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Meet getMeet() {
        return meet;
    }

    public void setMeet(Meet meet) {
        this.meet = meet;
    }
}
