package com;

import java.util.*;

public class PatientStore {
    private static PatientStore instance;
    private Set<Patient> patientSet = new HashSet<>();

    private PatientStore() {
    }

    public static synchronized PatientStore getInstance() {
        if (instance == null)
            instance = new PatientStore();
        return instance;
    }

    public void add(Patient patient) {
        patientSet.add(patient);

    }

    public void remove(Patient patient) {
        patientSet.remove(patient);
    }

    Patient getPatient(String iD) {
        /*for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).id.equals(iD))
                return patientList.get(i);
        }*/
        for( Patient patient: patientSet) {
            if (patient.id.equals(iD))
                return patient;
        }
        return null;
    }

    Set<Patient> getPatientSet() {
        return patientSet;

    }

    boolean IsPatientAvailable(String iD) {
        /*for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).id.equals(iD))
                return true;
        }*/
        for( Patient patient: patientSet) {
            if (patient.id.equals(iD))
                return true;
        }
        return false;
    }
}

