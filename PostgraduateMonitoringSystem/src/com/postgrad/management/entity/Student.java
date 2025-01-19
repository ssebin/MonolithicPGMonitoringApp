package com.postgrad.management.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private String researchTopic;
    private Supervisor supervisor; // Association with Supervisor (nullable)
    private List<ProgressUpdate> progressUpdates; // Aggregation with ProgressUpdate

    // Constructor
    public Student(String studentId, String name, String email, String researchTopic) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.researchTopic = researchTopic;
        this.progressUpdates = new ArrayList<>();
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public void removeSupervisor() {
        this.supervisor = null;
    }

    public List<ProgressUpdate> getProgressUpdates() {
        return progressUpdates;
    }

    // Methods for managing progress updates
    public void addProgressUpdate(ProgressUpdate update) {
        progressUpdates.add(update);
    }

    public boolean removeProgressUpdate(ProgressUpdate update) {
        return progressUpdates.remove(update);
    }

    @Override
    public String toString() {
        return "Student Details:\n" +
               "-----------------------------\n" +
               "ID         : " + studentId + "\n" +
               "Name       : " + name + "\n" +
               "Email      : " + email + "\n" +
               "Research   : " + researchTopic + "\n" +
               "Supervisor : " + (supervisor != null ? supervisor.getName() : "None") + "\n" +
               "-----------------------------";
    }
}