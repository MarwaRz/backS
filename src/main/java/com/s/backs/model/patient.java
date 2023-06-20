package com.s.backs.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
@Entity
@Table(name = "Patsssssssssssssient",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cin"
                        + ""),
                @UniqueConstraint(columnNames = "email")
        })
public class patient{
    @Id
    private String cin;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    @Size(max = 20)
    private String nom_prenom;
    @NotBlank
    @Size(max = 20)
    @Email
    private int num;
    private String email;
    private String password;
    private String service;
    private String entreprise;



    public patient (int num,String nom_prenom, String email, String password, String cin, String service,String entreprise) {
        super();
        this.num=num;
        this.nom_prenom=nom_prenom ;
        this.email = email;
        this.password = password;
        this.cin=cin;
        this.service=service;
        this.entreprise=entreprise;


    }
    


    public patient() {
       super() ;
    }


}