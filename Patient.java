package com;

import java.util.Objects;

public class Patient {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return mobileNum == patient.mobileNum || Objects.equals(emailId, patient.emailId) || Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(id);
        return 5;
    }

    enum Gender {
        MALE, FEMALE, OTHER;
    }
    String name;
    String id;
    int age;
    long mobileNum;
    String emailId;
    String address;
    String city;
    String disease;
    Gender gender;

    @Override
    public String toString() {
        return "Patient{" +
                "name=" + name + "\n" +
                "id='" + id + "\n" +
                "age=" + age + "\n" +
                "mobileNum=" + mobileNum + "\n" +
                "emailId=" + emailId + "\n" +
                "address=" + address + "\n" +
                "city=" + city + "\n" +
                "disease=" + disease + "\n" +
                "gender=" + gender +
                '}';
    }
}

