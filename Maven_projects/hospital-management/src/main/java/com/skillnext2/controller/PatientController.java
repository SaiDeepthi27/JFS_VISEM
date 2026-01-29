package com.skillnext2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillnext2.entity.Patient;
import com.skillnext2.dao.PatientDAO;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientDAO dao;

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient p) {
        dao.savePatient(p);
        return "Patient Registered Successfully";
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return dao.getAllPatients();
    }
}





