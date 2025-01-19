package com.postgrad.management.control;

import com.postgrad.management.entity.Supervisor;

import java.util.HashMap;
import java.util.List;

public class SupervisorManagement {
    private HashMap<String, Supervisor> supervisors = new HashMap<>();

    // Add a supervisor
    public void addSupervisor(Supervisor supervisor) {
        supervisors.put(supervisor.getSupervisorId(), supervisor);
    }

    // Remove a supervisor
    public boolean removeSupervisor(String supervisorId) {
        return supervisors.remove(supervisorId) != null;
    }

    // Edit supervisor information
    public boolean editSupervisorInformation(String supervisorId, String name, String email, String officeRoom) {
        Supervisor supervisor = supervisors.get(supervisorId);
        if (supervisor != null) {
            supervisor.setName(name);
            supervisor.setEmail(email);
            supervisor.setOfficeRoom(officeRoom);
            return true;
        }
        return false;
    }

    // View supervisor information
    public Supervisor viewSupervisorInformation(String supervisorId) {
        return supervisors.get(supervisorId);
    }

    // Get all supervisors
    public List<Supervisor> getAllSupervisors() {
        return supervisors.values().stream().toList();
    }
}