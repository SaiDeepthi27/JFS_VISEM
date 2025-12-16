package com.skillnext2;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Saideepthi@01";

    // 🔹 CREATE
    public void addStudent(Student s) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student(name, email, course) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCourse());
        ps.executeUpdate();
        con.close();
    }

    // 🔹 READ (ALL)
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            list.add(new Student(
                rs.getInt("rollno"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("course")
            ));
        }
        con.close();
        return list;
    }

    // 🔹 READ (BY ID)
    public Student getStudentByRollno(int rollno) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "SELECT * FROM student WHERE rollno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, rollno);
        ResultSet rs = ps.executeQuery();

        Student s = null;
        if (rs.next()) {
            s = new Student(
                rs.getInt("rollno"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("course")
            );
        }
        con.close();
        return s;
    }

    // 🔹 UPDATE
    public void updateStudent(Student s) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE student SET name=?, email=?, course=? WHERE rollno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCourse());
        ps.setInt(4, s.getRollno());
        ps.executeUpdate();
        con.close();
    }

    // 🔹 DELETE
    public void deleteStudent(int rollno) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM student WHERE rollno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, rollno);
        ps.executeUpdate();
        con.close();
    }
}
