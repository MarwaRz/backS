
package com.s.backs.controller;


import com.s.backs.message.msj;

import com.s.backs.model.patient;

import com.s.backs.repository.PatientRepository;
import com.s.backs.service.ServicePatient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "http://localhost:4200/categorie")
public class PatientController {

    @Autowired
    ServicePatient categoriesService;
    PatientRepository P;

    @GetMapping("/lista")
    public ResponseEntity<List<patient>> ConsulterListCatégories() {
        List<patient> list = categoriesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/detailname/{cin}")
    public ResponseEntity<patient> getByCin(@PathVariable("cin") String cin) {
        if (!categoriesService.existsByCin(cin))
            return new ResponseEntity(new msj(" Catégories n'existe pas"), HttpStatus.NOT_FOUND);
        patient categories = categoriesService.getByCin(cin).get();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> ajoterCatégorie(@RequestBody patient patient) {


        if (categoriesService.existsByCin(patient.getCin()))
            return new ResponseEntity(new msj("Le nom  existe déja "), HttpStatus.BAD_REQUEST);


        patient categories = new patient(patient.getNum(), patient.getNom_prenom(), patient.getEmail(), patient.getPassword(), patient.getCin(), patient.getService(), patient.getEntreprise());
        categoriesService.save(categories);
        return new ResponseEntity(new msj("Catégorie ajouté avec succès"), HttpStatus.OK);


    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> modifierCatégories(@PathVariable("id") int id, @RequestBody patient Categories) {
        if (!categoriesService.existsById(id))
            return new ResponseEntity(new msj("n'existe pas"), HttpStatus.NOT_FOUND);


        patient categories = categoriesService.getOne(id).get();
        categories.setNum(Categories.getNum());
        categories.setNom_prenom(Categories.getNom_prenom());
        categories.setEmail(Categories.getEmail());
        categories.setPassword(Categories.getPassword());
        categories.setCin(Categories.getCin());
        categories.setService(Categories.getService());
        categories.setEntreprise(Categories.getEntreprise());


        categoriesService.save(categories);
        return new ResponseEntity(new msj("Catégorie modifié avec succès"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{cin}")
    public ResponseEntity<?> supprimerCatégorie(@PathVariable("cin") int cin) {

        categoriesService.delete(cin);
        return new ResponseEntity(new msj("supprimee"), HttpStatus.OK);
    }
}





