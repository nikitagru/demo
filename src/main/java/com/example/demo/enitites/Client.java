package com.example.demo.enitites;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@javax.persistence.Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;

    @OneToMany(mappedBy="client")
    private Collection<Reservation> reservations;
}
