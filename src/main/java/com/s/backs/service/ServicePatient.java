package com.s.backs.service;

import com.s.backs.model.patient;
import com.s.backs.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicePatient {

    @Autowired
    PatientRepository patientRepository;

    public List<patient> list(){
        return patientRepository.findAll();
    }

    public Optional<patient> getOne(int id){
        return patientRepository.findById(id);
    }

    public Optional<patient> getByCin(String cin){
        return patientRepository.findByCin(cin);
    }

    public void  save(patient patient){
        patientRepository.save(patient);
    }

    public void delete(int id){
        patientRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return patientRepository.existsById(id);
    }

    public boolean existsByCin(String cin){
        return patientRepository.existsByCin(cin);
    }
}
