package com.skillnext2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnext2.entity.Appointment;
import com.skillnext2.repository.AppointmentRepository;

@Service
public class AppointmentDAO {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Save Appointment
    public void saveAppointment(Appointment appointment) {

        appointmentRepository.save(appointment);
    }

    // Get All Appointments
    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }
}


