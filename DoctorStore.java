package com;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

    public class DoctorStore {
        private static DoctorStore instance;
        private Set<Doctor> doctorList = new HashSet<>();

        private DoctorStore() {
        }

        public static DoctorStore getInstance() {
            if (instance == null)
                instance = new DoctorStore();
            return instance;
        }

        void add(Doctor doctor) {

            doctorList.add(doctor);
        }

        public void remove(Doctor doctor) {

            doctorList.remove(doctor);
        }

        Doctor getDoctor(String iD) {
        /*for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).id.equals(iD))
                return doctorList.get(i);
        }*/
            for( Doctor doctor: doctorList) {
                if (doctor.id.equals(iD))
                    return doctor;
            }
            return null;
        }

        Set<Doctor> getDoctorList() {
            return doctorList;
        }

        boolean IsDoctorAvailable(String iD) {
        /*for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).id.equals(iD))
                return true;
        }*/
            for( Doctor doctor: doctorList) {
                if (doctor.id.equals(iD))
                    return true;
            }
            return false;
        }
    }

