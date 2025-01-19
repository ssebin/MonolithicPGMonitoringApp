package com.postgrad.management.control;

import com.postgrad.management.entity.ProgressUpdate;
import com.postgrad.management.entity.Student;

import java.util.Date;
import java.util.List;

public class ProgressUpdateManagement {
    private final StudentManagement studentManagement;

    // Constructor
    public ProgressUpdateManagement(StudentManagement studentManagement) {
        this.studentManagement = studentManagement;
    }

    // Add a progress update for a student
    public boolean addProgressUpdate(String studentId, ProgressUpdate update) {
        Student student = studentManagement.viewStudentInformation(studentId);
        if (student != null) {
            student.addProgressUpdate(update);
            return true;
        }
        return false;
    }

    // Remove a progress update from a student
    public boolean removeProgressUpdate(String studentId, Date updateDate) {
        Student student = studentManagement.viewStudentInformation(studentId);
        if (student != null) {
            List<ProgressUpdate> updates = student.getProgressUpdates();
            ProgressUpdate updateToRemove = updates.stream()
                    .filter(update -> update.getDate().equals(updateDate))
                    .findFirst()
                    .orElse(null);

            if (updateToRemove != null) {
                student.removeProgressUpdate(updateToRemove);
                return true;
            }
        }
        return false;
    }

    // Edit a progress update for a student
    public boolean editProgressUpdate(String studentId, Date updateDate, String newContent) {
        Student student = studentManagement.viewStudentInformation(studentId);
        if (student != null) {
            for (ProgressUpdate update : student.getProgressUpdates()) {
                if (update.getDate().equals(updateDate)) {
                    update.setContent(newContent);
                    return true;
                }
            }
        }
        return false;
    }

    // View progress updates of a student
    public List<ProgressUpdate> viewProgressUpdatesOfStudent(String studentId) {
        Student student = studentManagement.viewStudentInformation(studentId);
        if (student != null) {
            return student.getProgressUpdates();
        }
        return null;
    }
}