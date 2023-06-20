package com.s.backs.repository;

import com.s.backs.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Locale.Category;

@Repository
public interface PatientRepository extends JpaRepository<patient, Integer> {
    Optional<patient> findByCin(String cin);
    boolean existsByCin(String cin);

}
