package com.skillnext2;

public class Student {
    private int rollno;
    private String name;
    private String email;
    private String course;

    public Student() {}

    // For INSERT
    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // For UPDATE
    public Student(int rollno, String name, String email, String course) {
        this.rollno = rollno;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public int getRollno() { return rollno; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }

    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name +
               ", email=" + email + ", course=" + course + "]";
    }
}
