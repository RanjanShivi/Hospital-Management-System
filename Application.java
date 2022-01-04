package com;

import java.util.*;

import static com.Constant.SELECTION_MENU_EXIT;

public class Application{
    public static void main(String[] args) {
        int option = 0;
        Application app = new Application();
        UserInterface userInterface = UserInterface.getInstance();
        do {
            option = userInterface.showMainMenu();
            app.handleUserSelection(option);
        } while (option != Constant.MAIN_MENU_EXIT);
    }

    void handleUserSelection(int option){
        UserInterface userInterface = UserInterface.getInstance();
        int doctorOption = 0, patientOption = 0, appointmentOption = 0;
        switch (option){
            case 1:
                do {
                doctorOption = userInterface.showDoctorMenu();
                handleUserSelectionDoctor(doctorOption);
                } while (doctorOption != SELECTION_MENU_EXIT);
                break;
            case 2:
                do {
                    patientOption = userInterface.showPatientMenu();
                    handleUserSelectionPatient(patientOption);
                }while (patientOption != SELECTION_MENU_EXIT);
                break;
            case 3:
                do {
                    appointmentOption = userInterface.showAppointmentMenu();
                    handleUserSelectionAppointment(appointmentOption);
                }while (appointmentOption != SELECTION_MENU_EXIT);
                break;
            case Constant.MAIN_MENU_EXIT:
                System.out.println("EXIT MAIN MENU");
                break;
            default:
                System.out.println("WRONG OPTION ENTERED");
        }
    }

    void handleUserSelectionDoctor(int option) {
        UserInterface userInterface = UserInterface.getInstance();
        DoctorStore doctorStore = DoctorStore.getInstance();
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1://add doctor
                addDoctor();
                break;
            case 2://update doctor
                System.out.println("Enter the id of the doctor you want to update ");
                String doctorIDToUpdate = scanner.nextLine();
                Doctor doctor = doctorStore.getDoctor(doctorIDToUpdate);
                if (doctor != null)
                    userInterface.updateDoctor(doctor);
                else
                    System.out.println("Wrong doctor id entered");
                break;
            case 3://Remove Doctor
                System.out.println("Enter the iD of the doctor you want to remove");
                String doctorIDToRemove = scanner.nextLine();
                Doctor doctor1 = doctorStore.getDoctor(doctorIDToRemove);
                doctorStore.remove(doctor1);
                break;
            case 4://Print Doctor
                Set doctorList = doctorStore.getDoctorSet();
                userInterface.printAllDoctor(doctorList);
                break;
            case Constant.SELECTION_MENU_EXIT:
                System.out.println("EXIT DOCTOR MENU");
                break;
            default:
                System.out.println("Wrong Option Entered");
        }
    }


    void handleUserSelectionPatient(int option) {
        UserInterface userInterface = UserInterface.getInstance();
        PatientStore patientStore = PatientStore.getInstance();
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                addPatient();
                break;
            case 2:
                System.out.println("Enter the id of the patient you want to update ");
                String patientIDToUpdate = scanner.nextLine();
                Patient patient = patientStore.getPatient(patientIDToUpdate);
                if (patient != null)
                    userInterface.updatePatient(patient);
                else
                    System.out.println("Wrong patient id entered");
                break;
            case 3:
                System.out.println("Enter the iD of the patient you want to remove");
                String patientIDToRemove = scanner.nextLine();
                Patient patient1 = patientStore.getPatient(patientIDToRemove);
                patientStore.remove(patient1);
                break;
            case 4:
                Set patientList = patientStore.getPatientSet();
                userInterface.printAllPatient(patientList);
                break;
            case SELECTION_MENU_EXIT:
                System.out.println("EXIT PATIENT MENU");
                break;
            default:
                System.out.println("WRONG CHOICE ENTERED");
                break;
        }
    }

    void handleUserSelectionAppointment(int option){
        UserInterface userInterface = UserInterface.getInstance();
        AppointmentStore appointmentStore = AppointmentStore.getInstance();
        Scanner scanner = new Scanner(System.in);
        switch (option){
            case 1:
                addAppointment();
                break;
            case 2:
                System.out.println("Enter appointment id to update");
                String appointmentIdToUpdate = scanner.next();
                Appointment appointment = appointmentStore.getAppointment(appointmentIdToUpdate);
                if (appointment != null )
                    userInterface.updateAppointment(appointment);
                else
                    System.out.println("Enter correct id");
                break;
            case 3:
                System.out.println("Enter Appointment Id to remove");
                String appointmentIDToRemove = scanner.next();
                Appointment appointment1 = appointmentStore.getAppointment(appointmentIDToRemove);
                appointmentStore.remove(appointment1);
                break;
            case 4:
                Set appointmentList = appointmentStore.getAppointmentSet();
                userInterface.printAllAppointment(appointmentList);
                break;
            case SELECTION_MENU_EXIT:
                System.out.println("EXIT APPOINTMENT MENU");
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

