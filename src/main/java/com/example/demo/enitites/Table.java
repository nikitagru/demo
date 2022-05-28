package com.example.demo.enitites;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@javax.persistence.Table(name = "tables")
@Data
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int guestsCount;
    private String image;

    @OneToMany(mappedBy="client")
    private Collection<Reservation> reservations;
}
