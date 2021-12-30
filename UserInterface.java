package com;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.Constant.*;

public class UserInterface {
    private static UserInterface instance;

    private UserInterface() {
    }

    public static UserInterface getInstance() {
        if (instance == null)
            instance = new UserInterface();
        return instance;
    }

    public int showMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("MAIN MAENU\nEnter your choice\n 1.Add Doctor\n 2.Update Doctor\n 3.Delete Doctor\n 4.Print all Doctor\n" +
                " 5.Add Patient\n 6.Update Patient\n 7.Delete Patient\n 8.Print all Patient\n" +
                " 9.Add Appointment\n 10.Update Appointment\n 11.Delete Appointment\n 12.Print all Appointment\n " + Constant.EXIT + ".Exit");


        int option = sc.nextInt();
        return option;

    }

    public void setGender(Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press\n 1 for female\n 2 for male\n 3 for others");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                patient.gender = Patient.Gender.FEMALE;
                break;
            case 2:
                patient.gender = Patient.Gender.MALE;
                break;
            case 3:
                patient.gender = Patient.Gender.OTHER;
                break;
        }
    }

    public Doctor getDoctorDetails() {
        Scanner scanner = new Scanner(System.in);
        Doctor doctor = new Doctor();
        System.out.println("Enter the doctor id");
        doctor.id = scanner.nextLine();
        System.out.println("Enter the doctor name");
        doctor.name = scanner.nextLine();
        System.out.println("Enter the doctor Specializatin");
        doctor.specialization = scanner.nextLine();
        System.out.println("enter the doctor emailid");
        doctor.emailId = scanner.nextLine();
        System.out.println("Enter the doctor phone number");
        doctor.mobileNum = scanner.nextInt();

        doctor.availability = new HashMap<>();
        ;
        doctor.availability.put(Doctor.WeekDays.SUN, "10 AM to 12 PM");
        doctor.availability.put(Doctor.WeekDays.MON, "12 PM to 2 PM");
        doctor.availability.put(Doctor.WeekDays.TUE, "2 PM to 4 PM");
        doctor.availability.put(Doctor.WeekDays.WED, "4 PM to 6 PM");
        doctor.availability.put(Doctor.WeekDays.THU, "6 PM to 8 PM");
        doctor.availability.put(Doctor.WeekDays.FRI, "8 PM to 10 PM");
        doctor.availability.put(Doctor.WeekDays.SAT, "10 PM to 12 AM");

        return doctor;
    }

    public void updateDoctor(Doctor doctor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which parameter to update:\n1. Update Name\n2. Update specialist\n3. Update Mobile No.\n"
                + "4. Update e-mail\n" + Constant.DOCTOREXIT + ". EXIT");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter name to update");
                doctor.name = sc.nextLine();
                break;
            case 2:
                System.out.println("Enter specialization to update");
                doctor.specialization = sc.nextLine();
                break;
            case 3:
                System.out.println("Enter Mobile No. to update");
                doctor.mobileNum = sc.nextInt();
                break;
            case 4:
                System.out.println("Enter e-mail to update");
                doctor.emailId = sc.nextLine();
                break;
            case DOCTOREXIT:
            default:
                System.out.println("Wrong Choice");
        }
    }

    public Patient getPatientDetails() {
        Patient patient = new Patient();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the patient id");
        patient.id = scanner.nextLine();
        System.out.println("Enter the patient name");
        patient.name = scanner.nextLine();
        System.out.println("Enter the patient disease");
        patient.disease = scanner.nextLine();
        System.out.println("Enter the patient address");
        patient.disease = scanner.nextLine();
        System.out.println("enter the patient city");
        patient.city = scanner.nextLine();
        System.out.println("enter the patient email");
        patient.emailId = scanner.nextLine();
        System.out.println("Enter the patient phone number");
        patient.mobileNum = scanner.nextInt();
        System.out.println("Enter the patient age");
        patient.age = scanner.nextInt();
        System.out.println("Enter the gender");
        setGender(patient);

        return patient;
    }

    public void updatePatient(Patient patient) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which parameter to update:\n1. Update Name\n2. Update age\n3. Update Mobile No.\n"
                + "4. Update e-mail\n5. Update address\n6. Update City\n7. Update Disease\n8. Update Gender\n"
                + Constant.PATIENTEXIT + " .Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter name to update");
                patient.name = sc.nextLine();
            case 2:
                System.out.println("Enter age to update");
                patient.age = sc.nextInt();
            case 3:
                System.out.println("Enter Mobile No. to update");
                patient.mobileNum = sc.nextInt();
            case 4:
                System.out.println("Enter e-mail to update");
                patient.emailId = sc.nextLine();
                break;
            case 5:
                System.out.println("Enter address to update");
                patient.address = sc.nextLine();
                break;
            case 6:
                System.out.println("Enter city to update");
                patient.city = sc.nextLine();
                break;
            case 7:
                System.out.println("Enter disease to update");
                patient.disease = sc.nextLine();
                break;
            case 8:
                System.out.println("Enter the updated gender");
                setGender(patient);
            case Constant.PATIENTEXIT:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Wrong Choice");
        }
    }

    public Appointment getAppointmentDetails() {
        Scanner sc = new Scanner(System.in);
        Appointment appoint = new Appointment();
        System.out.println("Enter Appointment Id");
        appoint.appointmentID = sc.next();
        System.out.println("Enter doctor id");
        appoint.doctorId = sc.nextLine();
        DoctorStore doctorStore = DoctorStore.getInstance();
        if (doctorStore.IsDoctorAvailable(appoint.doctorId)) {
            System.out.println("Enter the PatientId :");
            appoint.patientId = sc.nextLine();
            PatientStore patientStore = PatientStore.getInstance();
            if (patientStore.IsPatientAvailable(appoint.patientId)) {
                System.out.println("Enter the RoomNumber :");
                appoint.roomNum = sc.nextInt();
                System.out.println("Enter the Appointment Date like dd-MMM-yyyy");
                Scanner scanner = new Scanner(System.in);
                appoint.appointmentDate = scanner.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                try {
                    Date date = formatter.parse(appoint.appointmentDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else
                System.out.println("Patient id is not available");
        } else
            System.out.println("Doctor id not available ");
        return appoint;
    }

    public Appointment updateAppointment(Appointment appointment) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter where u want to update \n1.patientId\n2.doctorId\n3.appointmentDate\n4.roomNumber\n"
                + APPOINTMENTEXIT + ".Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter patientId");
                appointment.patientId = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter doctorId");
                appointment.doctorId = scanner.next();
                break;
            case 3:
                System.out.println("Enter the Appointment Date like dd-MMM-yyyy");
                Scanner scanner2 = new Scanner(System.in);
                appointment.appointmentDate = scanner2.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                try {
                    Date date = formatter.parse(appointment.appointmentDate);
                } catch (ParseException e) {
                    e.printStackTrace(); //Print Exception in Details
                }
                break;
            case 4:
                System.out.println("Enter roomNumber");
                appointment.doctorId = scanner.next();
                break;
            case APPOINTMENTEXIT:
                System.out.println("EXIT");
                break;
            default:
                System.out.println("Enter correct option.");
                break;
        }
        return appointment;
    }


    void printAllDoctor(Set<Doctor> doctorList) {

        /*for (int i = 0; i < doctor.size(); i++) {
            System.out.println(doctor.get(i));
        }*/
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }
    }

    void printAllPatient(Set<Patient> patientList) {
        /*for (int i = 0; i < patient.size(); i++) {
            System.out.println(patient.get(i));
        }*/
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }

    void printAllAppointment(Set<Appointment> appointmentList) {
        for (Appointment appointment : appointmentList) {
            System.out.println(appointment);
        }
    }
}
