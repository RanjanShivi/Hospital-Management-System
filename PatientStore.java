package com;

import java.util.*;

public class PatientStore {
    private static PatientStore instance;
    private Set<Patient> patientList = new HashSet<>();

    private PatientStore() {
    }

    public static PatientStore getInstance() {
        if (instance == null)
            instance = new PatientStore();
        return instance;
    }

    public void add(Patient patient) {
        patientList.add(patient);

    }

    public void remove(Patient patient) {
        patientList.remove(patient);
    }

    Patient getPatient(String iD) {
        /*for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).id.equals(iD))
                return patientList.get(i);
        }*/
        for( Patient patient: patientList) {
            if (patient.id.equals(iD))
                return patient;
        }
        return null;
    }

    Set<Patient> getPatientList() {
        return patientList;

    }

    boolean IsPatientAvailable(String iD) {
        /*for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).id.equals(iD))
                return true;
        }*/
        for( Patient patient: patientList) {
            if (patient.id.equals(iD))
                return true;
        }
        return false;
    }
}

