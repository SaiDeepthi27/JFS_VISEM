package com.skillnext2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillnext2.dao.DoctorDAO;
import com.skillnext2.entity.Doctor;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorDAO dao;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor d) {
        dao.saveDoctor(d);
        return "Doctor Inserted Successfully";
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return dao.getAllDoctors();
    }
}


