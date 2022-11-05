package edu.uptc.apirest.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "rooms")
@Getter @Setter
@AllArgsConstructor
public class Room{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, nullable = false)
    private String description;

    @Column(nullable = false)
    private short capacity;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="room")
    @JsonIgnoreProperties({"room","act"})
    private List<Meet> meets;

    public Room() {
        meets = new ArrayList<>();
    }

    public Room(String description, short capacity) {
        this();
        this.description = description;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addMeet( Meet meet ){
        meets.add( meet );
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public List<Meet> getMeets() {
        return meets;
    }

}
