package com;

import java.util.Map;
import java.util.Objects;

public class Doctor {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return mobileNum == doctor.mobileNum || Objects.equals(emailId, doctor.emailId) || Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(id);
        return 5;
    }

    enum WeekDays {
        SUN, MON, TUE, WED, THU, FRI, SAT;
    }
    String id;
    String name;
    String specialization;
    long mobileNum;
    String emailId;
    Map<WeekDays, String > availability;

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id + "\n" +
                "name=" + name + "\n" +
                "specislization=" + specialization + "\n" +
                "mobilenum=" + mobileNum + "\n" +
                "emailId=" + emailId + "\n" +
                "availability=" + availability +
                '}';
    }
}
