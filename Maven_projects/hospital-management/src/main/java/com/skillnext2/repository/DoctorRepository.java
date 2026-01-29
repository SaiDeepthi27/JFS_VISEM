package com.skillnext2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillnext2.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}

