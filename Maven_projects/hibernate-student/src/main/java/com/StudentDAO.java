package com.skillnext2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentDAO {

    // INSERT
    public void addStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();
    }

    // READ ALL
    public List<Student> getAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Student> query = session.createQuery("from Student", Student.class);
        List<Student> students = query.list();
        session.close();
        return students;
    }

    // READ BY ID
    public Student getStudentById(int rollno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class, rollno);
        session.close();
        return student;
    }

    // UPDATE
    public void updateStudent(int rollno, String newCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, rollno);
        if (student != null) {
            student.setCourse(newCourse);
            session.update(student);
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public void deleteStudent(int rollno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, rollno);
        if (student != null) {
            session.delete(student);
        }

        tx.commit();
        session.close();
    }
}
