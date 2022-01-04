package com;
import java.util.HashSet;
import java.util.Set;

public class AppointmentStore {
    private static AppointmentStore instance;
    Set<Appointment> appointmenSet = new HashSet<>();

    private AppointmentStore() {
    }

    public static synchronized AppointmentStore getInstance() {
        if (instance == null)
            instance = new AppointmentStore();
        return instance;
    }

    public void add(Appointment appoint) {

        appointmenSet.add(appoint);
    }

    Set<Appointment> getAppointmentSet(){
        return appointmenSet;
    }

    Appointment getAppointment(String iD) {
        /*for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).appointmentID.equals(id)){
                return appointmentList.get(i);
            }
        }*/
        for( Appointment appointment: appointmenSet) {
            if (appointment.appointmentID.equals(iD))
                return appointment;
        }
        return null;
    }

    public void remove(Appointment appointment) {
        appointmenSet.remove(appointment);
    }
}
