package com.skillnext2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                // 1️⃣ INSERT
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student student = new Student(name, email, course);
                    dao.addStudent(student);

                    System.out.println("✅ Student inserted successfully!");
                    break;

                // 2️⃣ VIEW ALL
                case 2:
                    List<Student> students = dao.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("⚠ No students found.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            System.out.println(
                                s.getRollno() + " | " +
                                s.getName() + " | " +
                                s.getEmail() + " | " +
                                s.getCourse()
                            );
                        }
                    }
                    break;

                // 3️⃣ UPDATE
                case 3:
                    System.out.print("Enter Student RollNo to update: ");
                    int updateRollno = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(updateRollno, newCourse);
                    System.out.println("✅ Student updated successfully!");
                    break;

                // 4️⃣ DELETE
                case 4:
                    System.out.print("Enter Student RollNo to delete: ");
                    int deleteRollno = sc.nextInt();

                    dao.deleteStudent(deleteRollno);
                    System.out.println("✅ Student deleted successfully!");
                    break;

                // 5️⃣ EXIT
                case 5:
                    System.out.println("🚪 Exiting application...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
