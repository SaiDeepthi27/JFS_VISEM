package com.skillnext2;

import com.skillnext2.dao.AppointmentDAO;
import com.skillnext2.dao.DoctorDAO;
import com.skillnext2.dao.PatientDAO;
import com.skillnext2.entity.Appointment;
import com.skillnext2.entity.Doctor;
import com.skillnext2.entity.Patient;

public class App {
    public static void main(String[] args) {

        DoctorDAO doctorDAO = new DoctorDAO();
        PatientDAO patientDAO = new PatientDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        Doctor doctor = new Doctor(
                "Dr. Rajesh Verma",
                "Neurology",
                "Morning"
        );

        Patient patient = new Patient(
                "Sita Devi",
                45,
                "Female",
                "9988776655"
        );

        doctorDAO.saveDoctor(doctor);
        patientDAO.savePatient(patient);

        Appointment appointment = new Appointment(
                patient.getId(),
                doctor.getId(),
                "2026-01-15",
                "BOOKED"
        );

        appointmentDAO.saveAppointment(appointment);

        System.out.println("Doctor, Patient & Appointment saved using DAO layer!");
    }
}
