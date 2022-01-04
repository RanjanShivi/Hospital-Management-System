package com;

import java.util.HashSet;
import java.util.Set;

public class DoctorStore {
        private static DoctorStore instance;
        private Set<Doctor> doctorSet = new HashSet<>();

        private DoctorStore() {
        }

        public static synchronized DoctorStore getInstance() {
            if (instance == null)
                instance = new DoctorStore();
            return instance;
        }

        void add(Doctor doctor) {

            doctorSet.add(doctor);
        }

        public void remove(Doctor doctor) {

            doctorSet.remove(doctor);
        }

        Doctor getDoctor(String iD) {
        /*for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).id.equals(iD))
                return doctorList.get(i);
        }*/
            for( Doctor doctor: doctorSet) {
                if (doctor.id.equals(iD))
                    return doctor;
            }
            return null;
        }

        Set<Doctor> getDoctorSet() {
            return doctorSet;
        }

        boolean IsDoctorAvailable(String iD) {
        /*for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).id.equals(iD))
                return true;
        }*/
            for( Doctor doctor: doctorSet) {
                if (doctor.id.equals(iD))
                    return true;
            }
            return false;
        }
    }

