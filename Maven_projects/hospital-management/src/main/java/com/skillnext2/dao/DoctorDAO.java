package com.skillnext2.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.skillnext2.entity.Doctor;
import com.skillnext2.util.HibernateUtil;

@Service
public class DoctorDAO {

    public void saveDoctor(Doctor d) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(d);

        tx.commit();
        session.close();
    }

    public List<Doctor> getAllDoctors() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Doctor> list =
                session.createQuery("from Doctor", Doctor.class).list();

        session.close();

        return list;
    }
}

