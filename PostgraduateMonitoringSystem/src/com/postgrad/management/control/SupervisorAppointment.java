package com.postgrad.management.control;

import com.postgrad.management.entity.Student;
import com.postgrad.management.entity.Supervisor;

import java.util.List;

public class SupervisorAppointment {
    private final StudentManagement studentManagement;
    private final SupervisorManagement supervisorManagement;

    // Constructor
    public SupervisorAppointment(StudentManagement studentManagement, SupervisorManagement supervisorManagement) {
        this.studentManagement = studentManagement;
        this.supervisorManagement = supervisorManagement;
    }

    // Assign a supervisor to a student
    public boolean assignSupervisorToStudent(String studentId, String supervisorId) {
        Student student = studentManagement.viewStudentInformation(studentId);
        Supervisor supervisor = supervisorManagement.viewSupervisorInformation(supervisorId);

        if (student != null && supervisor != null) {
            supervisor.addStudent(student);
            return true;
        }
        return false;
    }

    // Remove a supervisor from a student
    public boolean removeSupervisorFromStudent(String studentId) {
        Student student = studentManagement.viewStudentInformation(studentId);
        if (student != null && student.getSupervisor() != null) {
            Supervisor supervisor = student.getSupervisor();
            supervisor.removeStudent(student);
            return true;
        }
        return false;
    }

    // View students without a supervisor
    public List<Student> viewStudentsWithoutSupervisor() {
        return studentManagement.getAllStudents()
                .stream()
                .filter(student -> student.getSupervisor() == null)
                .toList();
    }

    // Get all students under a specific supervisor
    public List<Student> getStudentsUnderSupervisor(String supervisorId) {
        Supervisor supervisor = supervisorManagement.viewSupervisorInformation(supervisorId);

        if (supervisor != null) {
            return supervisor.getStudents(); // Retrieve the list of students from the Supervisor entity
        }
        return List.of(); // Return an empty list if the supervisor is not found
    }
}