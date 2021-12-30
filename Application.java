package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application{
    public static void main(String[] args) {
        int option = 0;
        Application app = new Application();
        UserInterface userInterface = UserInterface.getInstance();
        do {
            option = userInterface.showMainMenu();
            app.handleUserSelection(option);
        } while (option != Constant.EXIT);
    }

    void handleUserSelection(int option){
        UserInterface userInterface = UserInterface.getInstance();
        DoctorStore doctorStore = DoctorStore.getInstance();
        PatientStore patientStore = PatientStore.getInstance();
        AppointmentStore appointmentStore = AppointmentStore.getInstance();
        Scanner scanner = new Scanner(System.in);
        switch(option){
            case 1:
                addDoctor();
                break;
            case 2:
                System.out.println("Enter the id of the doctor you want to update ");
                String doctorIDToUpdate = scanner.nextLine();
                Doctor doctor = doctorStore.getDoctor(doctorIDToUpdate);
                if(doctor != null)
                    userInterface.updateDoctor(doctor);
                else
                    System.out.println("Wrong doctor id entered");
                break;
            case 3:
                System.out.println("Enter the iD of the doctor you want to remove");
                String doctorIDToRemove = scanner.nextLine();
                Doctor doctor1 = doctorStore.getDoctor(doctorIDToRemove);
                doctorStore.remove(doctor1);
                break;
            case 4:
                Set doctorList = doctorStore.getDoctorList();
                userInterface.printAllDoctor(doctorList);
                break;
            case 5:
                addPatient();
                break;
            case 6:
                System.out.println("Enter the id of the patient you want to update ");
                String patientIDToUpdate = scanner.nextLine();
                Patient patient = patientStore.getPatient(patientIDToUpdate);
                if(patient != null)
                    userInterface.updatePatient(patient);
                else
                    System.out.println("Wrong patient id entered");
                break;
            case 7:
                System.out.println("Enter the iD of the patient you want to remove");
                String patientIDToRemove = scanner.nextLine();
                Patient patient1 = patientStore.getPatient(patientIDToRemove);
                patientStore.remove(patient1);
                break;
            case 8:
                Set patientList = patientStore.getPatientList();
                userInterface.printAllPatient(patientList);
                break;
            case 9:
                addAppointment();
                break;
            case 10:
                System.out.println("Enter appointment id to update");
                String appointmentIdToUpdate = scanner.next();
                Appointment appointment = appointmentStore.getAppointment(appointmentIdToUpdate);
                if (appointment != null )
                    userInterface.updateAppointment(appointment);
                else
                    System.out.println("Enter correct id");
                break;
            case 11:
                System.out.println("Enter Appointment Id to remove");
                String appointmentIDToRemove = scanner.next();
                Appointment appointment1 = appointmentStore.getAppointment(appointmentIDToRemove);
                appointmentStore.remove(appointment1);
                break;
            case 12:
                Set appointmentList = appointmentStore.getAppointmentList();
                userInterface.printAllAppointment(appointmentList);
                break;
            case Constant.EXIT:
                System.out.println("EXIT");
                break;
            default:
                System.out.println("Wrong Option ");
        }
    }

    void addDoctor() {
        UserInterface userInterface = UserInterface.getInstance();
        DoctorStore doctorStore = DoctorStore.getInstance();
        doctorStore.add(userInterface.getDoctorDetails());
    }

    void addPatient() {
        UserInterface userInterface = UserInterface.getInstance();
        PatientStore patientStore = PatientStore.getInstance();
        patientStore.add(userInterface.getPatientDetails());
    }
    void addAppointment(){
        UserInterface userInterface = UserInterface.getInstance();
        AppointmentStore appointmentStore = AppointmentStore.getInstance();
        appointmentStore.add(userInterface.getAppointmentDetails());
    }
}

