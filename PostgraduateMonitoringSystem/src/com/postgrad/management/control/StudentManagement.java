package com.postgrad.management.control;

import com.postgrad.management.entity.Student;

import java.util.HashMap;
import java.util.List;

public class StudentManagement {
    private HashMap<String, Student> students = new HashMap<>();

    // Add a student
    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    // Remove a student
    public boolean removeStudent(String studentId) {
        return students.remove(studentId) != null;
    }

    // Edit student details
    public boolean editStudentDetails(String studentId, String name, String email, String researchTopic) {
        Student student = students.get(studentId);
        if (student != null) {
            student.setName(name);
            student.setEmail(email);
            student.setResearchTopic(researchTopic);
            return true;
        }
        return false;
    }

    // View student information
    public Student viewStudentInformation(String studentId) {
        return students.get(studentId);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students.values().stream().toList();
    }
}