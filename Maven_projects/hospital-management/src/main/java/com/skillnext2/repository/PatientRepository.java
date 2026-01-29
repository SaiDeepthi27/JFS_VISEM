package com.skillnext2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillnext2.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
