package com;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppointmentStore {
    private static AppointmentStore instance;
    Set<Appointment> appointmentList = new HashSet<>();

    private AppointmentStore() {
    }

    public static AppointmentStore getInstance() {
        if (instance == null)
            instance = new AppointmentStore();
        return instance;
    }

    public void add(Appointment appoint) {

        appointmentList.add(appoint);
    }

    Set<Appointment> getAppointmentList(){
        return appointmentList;
    }

    Appointment getAppointment(String iD) {
        /*for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).appointmentID.equals(id)){
                return appointmentList.get(i);
            }
        }*/
        for( Appointment appointment: appointmentList) {
            if (appointment.appointmentID.equals(iD))
                return appointment;
        }
        return null;
    }

    public void remove(Appointment appointment) {
        appointmentList.remove(appointment);
    }
}
