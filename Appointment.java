package com;

public class Appointment {
    String appointmentID;
    String patientId;
    String doctorId;
    String appointmentDate;
    int roomNum;

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentID + "\n" +
                "patientId='" + patientId + "\n" +
                ", doctorId='" + doctorId + "\n" +
                ", appointmaentDate=" + appointmentDate +
                ", roomNum=" + roomNum +
                '}';
    }
}
