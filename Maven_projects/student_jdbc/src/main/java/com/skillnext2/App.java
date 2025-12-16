package com.skillnext2;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        try {
            while (true) {
                System.out.println("\n===== STUDENT JDBC CRUD APP =====");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. View Student by Roll No");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Course: ");
                        String course = sc.nextLine();
                        dao.addStudent(new Student(name, email, course));
                        System.out.println("Student Added");
                        break;

                    case 2:
                        List<Student> list = dao.getAllStudents();
                        for (Student s : list)
                            System.out.println(s);
                        break;

                    case 3:
                        System.out.print("Roll No: ");
                        int r = sc.nextInt();
                        Student s = dao.getStudentByRollno(r);
                        System.out.println(s != null ? s : "Student Not Found");
                        break;

                    case 4:
                        System.out.print("Roll No: ");
                        int ur = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Name: ");
                        String nn = sc.nextLine();
                        System.out.print("New Email: ");
                        String ne = sc.nextLine();
                        System.out.print("New Course: ");
                        String nc = sc.nextLine();
                        dao.updateStudent(new Student(ur, nn, ne, nc));
                        System.out.println("Student Updated");
                        break;

                    case 5:
                        System.out.print("Roll No: ");
                        dao.deleteStudent(sc.nextInt());
                        System.out.println("Student Deleted");
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
