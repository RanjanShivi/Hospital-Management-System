package com;

import java.util.Objects;

public class Appointment {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentID, that.appointmentID);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(appointmentID);
        return 5;
    }

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
