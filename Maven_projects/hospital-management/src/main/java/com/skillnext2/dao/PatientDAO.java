package com.skillnext2.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.skillnext2.entity.Patient;
import com.skillnext2.util.HibernateUtil;

@Service
public class PatientDAO {

    public void savePatient(Patient p) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(p);

        tx.commit();
        session.close();
    }

    public List<Patient> getAllPatients() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Patient> list = session
                .createQuery("from Patient", Patient.class)
                .list();

        session.close();

        return list;
    }
}

