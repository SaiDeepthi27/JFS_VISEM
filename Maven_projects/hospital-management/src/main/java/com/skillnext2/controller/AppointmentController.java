package com.skillnext2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillnext2.entity.Appointment;
import com.skillnext2.dao.AppointmentDAO;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentDAO appointmentDAO;

    // Add new Appointment
    @PostMapping("/add")
    public String addAppointment(@RequestBody Appointment appointment) {

        appointmentDAO.saveAppointment(appointment);

        return "Appointment Saved Successfully!";
    }

    // Get all Appointments
    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {

        return appointmentDAO.getAllAppointments();
    }
}

