package com.postgrad.management.view;

import com.postgrad.management.control.*;
import com.postgrad.management.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainUI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManagement studentManagement = new StudentManagement();
    private static final SupervisorManagement supervisorManagement = new SupervisorManagement();
    private static final SupervisorAppointment supervisorAppointment = new SupervisorAppointment(studentManagement, supervisorManagement);
    private static final ProgressUpdateManagement progressUpdateManagement = new ProgressUpdateManagement(studentManagement);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Postgraduate Monitoring System =====");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Supervisors");
            System.out.println("3. Supervisor Appointment");
            System.out.println("4. Manage Progress Updates");
            System.out.println("5. Exit \n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manageStudents();
                case 2 -> manageSupervisors();
                case 3 -> supervisorAppointmentMenu();
                case 4 -> progressUpdateManagementMenu();
                case 5 -> {
                    System.out.println("\nExiting the Postgraduate Monitoring System. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    // Manage Students Menu
    private static void manageStudents() {
        while (true) {
            System.out.println("\n=== Manage Students ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Edit Student Details");
            System.out.println("4. View Student Information");
            System.out.println("5. View All Students");
            System.out.println("6. Back to Main Menu \n");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> editStudentDetails();
                case 4 -> viewStudentInformation();
                case 5 -> viewAllStudents();
                case 6 -> { return; }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Research Topic: ");
        String topic = scanner.nextLine();

        Student student = new Student(id, name, email, topic);
        studentManagement.addStudent(student);
        System.out.println("\nStudent added successfully!");
    }

    private static void removeStudent() {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        if (studentManagement.removeStudent(id)) {
            System.out.println("\nStudent removed successfully!");
        } else {
            System.out.println("\nStudent not found.");
        }
    }

    private static void editStudentDetails() {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter New Research Topic: ");
        String topic = scanner.nextLine();

        if (studentManagement.editStudentDetails(id, name, email, topic)) {
            System.out.println("\nStudent details updated successfully!");
        } else {
            System.out.println("\nStudent not found.");
        }
    }

    private static void viewStudentInformation() {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        Student student = studentManagement.viewStudentInformation(id);
        if (student != null) {
        	System.out.println("\n");
            System.out.println(student);
        } else {
        	scanner.nextLine(); // Consume newline
            System.out.println("\nStudent not found.");
        }
    }

    private static void viewAllStudents() {
        List<Student> students = studentManagement.getAllStudents();
        if (!students.isEmpty()) {
        	System.out.println("\n");
        	students.forEach(student -> {
                System.out.println(student);
                System.out.println();
            });
        } else {
            System.out.println("\nNo students found.");
        }
    }

    // Manage Supervisors Menu
    private static void manageSupervisors() {
        while (true) {
            System.out.println("\n=== Manage Supervisors ===");
            System.out.println("1. Add Supervisor");
            System.out.println("2. Remove Supervisor");
            System.out.println("3. Edit Supervisor Details");
            System.out.println("4. View Supervisor Information");
            System.out.println("5. View All Supervisors");
            System.out.println("6. Back to Main Menu");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addSupervisor();
                case 2 -> removeSupervisor();
                case 3 -> editSupervisorDetails();
                case 4 -> viewSupervisorInformation();
                case 5 -> viewAllSupervisors();
                case 6 -> { return; }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void addSupervisor() {
        System.out.print("\nEnter Supervisor ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Office Room: ");
        String room = scanner.nextLine();

        Supervisor supervisor = new Supervisor(id, name, email, room);
        supervisorManagement.addSupervisor(supervisor);
        System.out.println("\nSupervisor added successfully!");
    }

    private static void removeSupervisor() {
        System.out.print("\nEnter Supervisor ID: ");
        String id = scanner.nextLine();
        if (supervisorManagement.removeSupervisor(id)) {
            System.out.println("\nSupervisor removed successfully!");
        } else {
            System.out.println("\nSupervisor not found.");
        }
    }

    private static void editSupervisorDetails() {
        System.out.print("\nEnter Supervisor ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter New Office Room: ");
        String room = scanner.nextLine();

        if (supervisorManagement.editSupervisorInformation(id, name, email, room)) {
            System.out.println("\nSupervisor details updated successfully!");
        } else {
            System.out.println("\nSupervisor not found.");
        }
    }

    private static void viewSupervisorInformation() {
        System.out.print("\nEnter Supervisor ID: ");
        String id = scanner.nextLine();
        Supervisor supervisor = supervisorManagement.viewSupervisorInformation(id);
        if (supervisor != null) {
        	System.out.println("\n");
            System.out.println(supervisor);
        } else {
            System.out.println("\nSupervisor not found.");
        }
    }

    private static void viewAllSupervisors() {
        List<Supervisor> supervisors = supervisorManagement.getAllSupervisors();
        if (!supervisors.isEmpty()) {
        	System.out.println("\n");
            supervisors.forEach(supervisor -> {
                System.out.println(supervisor);
                System.out.println();
            });
        } else {
            System.out.println("\nNo supervisors found.");
        }
    }

    // Supervisor Appointment Menu
    private static void supervisorAppointmentMenu() {
        while (true) {
            System.out.println("\n=== Supervisor Appointment ===");
            System.out.println("1. Assign Supervisor to Student");
            System.out.println("2. Remove Supervisor from Student");
            System.out.println("3. View Students Without a Supervisor");
            System.out.println("4. View Students Under a Supervisor");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> assignSupervisor();
                case 2 -> removeSupervisorFromStudent();
                case 3 -> viewStudentsWithoutSupervisor();
                case 4 -> viewStudentsUnderSupervisor();
                case 5 -> { return; }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void assignSupervisor() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Supervisor ID: ");
        String supervisorId = scanner.nextLine();
        if (supervisorAppointment.assignSupervisorToStudent(studentId, supervisorId)) {
            System.out.println("\nSupervisor assigned successfully!");
        } else {
            System.out.println("\nFailed to assign supervisor. Check IDs.");
        }
    }

    private static void removeSupervisorFromStudent() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        if (supervisorAppointment.removeSupervisorFromStudent(studentId)) {
            System.out.println("\nSupervisor removed successfully!");
        } else {
            System.out.println("\nFailed to remove supervisor. Check Student ID.");
        }
    }

    private static void viewStudentsWithoutSupervisor() {
        List<Student> students = supervisorAppointment.viewStudentsWithoutSupervisor();
        if (!students.isEmpty()) {
        	System.out.println("\n");
        	students.forEach(student -> {
                System.out.println(student);
                System.out.println();
            });
        } else {
            System.out.println("\nAll students have supervisors.");
        }
    }

    private static void viewStudentsUnderSupervisor() {
        System.out.print("\nEnter Supervisor ID: ");
        String supervisorId = scanner.nextLine();
        List<Student> students = supervisorAppointment.getStudentsUnderSupervisor(supervisorId);
        if (!students.isEmpty()) {
        	System.out.println("\n");
        	students.forEach(student -> {
                System.out.println(student);
                System.out.println(); 
            });
        } else {
            System.out.println("\nNo students found for this supervisor.");
        }
    }

    // Progress Update Management Menu
    private static void progressUpdateManagementMenu() {
        while (true) {
            System.out.println("\n=== Manage Progress Updates ===");
            System.out.println("1. Add Progress Update");
            System.out.println("2. Remove Progress Update");
            System.out.println("3. Edit Progress Update");
            System.out.println("4. View Progress Updates of a Student");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addProgressUpdate();
                case 2 -> removeProgressUpdate();
                case 3 -> editProgressUpdate();
                case 4 -> viewProgressUpdatesOfStudent();
                case 5 -> { return; }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void addProgressUpdate() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Update Date (dd-MM-yyyy): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter Update Content: ");
        String content = scanner.nextLine();

        try {
        	Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
            ProgressUpdate update = new ProgressUpdate(date, content);
            if (progressUpdateManagement.addProgressUpdate(studentId, update)) {
                System.out.println("\nProgress update added successfully!");
            } else {
                System.out.println("\nFailed to add progress update. Check Student ID.");
            }
        } catch (ParseException e) {
            System.out.println("\nInvalid date format. Please use dd-MM-yyyy.");
        }
    }

    private static void removeProgressUpdate() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Update Date (dd-MM-yyyy): ");
        String dateStr = scanner.nextLine();

        try {
        	Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
            if (progressUpdateManagement.removeProgressUpdate(studentId, date)) {
                System.out.println("\nProgress update removed successfully!");
            } else {
                System.out.println("\nFailed to remove progress update. Check IDs.");
            }
        } catch (ParseException e) {
        	System.out.println("\nInvalid date format. Please use dd-MM-yyyy.");
        }
    }

    private static void editProgressUpdate() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Update Date (dd-MM-yyyy): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter New Content: ");
        String content = scanner.nextLine();

        try {
        	Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
            if (progressUpdateManagement.editProgressUpdate(studentId, date, content)) {
                System.out.println("\nProgress update edited successfully!");
            } else {
                System.out.println("\nFailed to edit progress update. Check IDs.");
            }
        } catch (ParseException e) {
        	System.out.println("\nInvalid date format. Please use dd-MM-yyyy.");
        }
    }

    private static void viewProgressUpdatesOfStudent() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        List<ProgressUpdate> updates = progressUpdateManagement.viewProgressUpdatesOfStudent(studentId);
        if (updates != null && !updates.isEmpty()) {
        	System.out.println("\n");
            updates.forEach(update -> {
                System.out.println(update);
                System.out.println(); 
            });
        } else {
            System.out.println("\nNo progress updates found for this student.");
        }
    }
}