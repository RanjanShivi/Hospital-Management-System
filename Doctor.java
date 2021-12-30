package com;

import java.util.Map;

public class Doctor {
    enum WeekDays {
        SUN, MON, TUE, WED, THU, FRI, SAT
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
