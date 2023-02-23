package com.attornatus.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "adress")
public class Adress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "adress")
    private String adress;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    @Column (name = "Principal")
    private boolean principalAdress;

    @ManyToOne
    private Users users;

}

