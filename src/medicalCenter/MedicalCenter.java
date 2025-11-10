package medicalCenter;

import medicalCenter.doctor.Doctor;
import medicalCenter.doctor.DoctorStorage;
import medicalCenter.exception.IllegalIDException;
import medicalCenter.exception.ProfessionNotFoundException;
import medicalCenter.patient.Patient;
import medicalCenter.patient.PatientStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenter implements Commands {

    private static Scanner sc = new Scanner(System.in);
    private static DoctorStorage doctorStorage = new DoctorStorage();
    private static PatientStorage patientStorage = new PatientStorage();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate registrationDate = null;

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            Commands.printCommands();
            String command = sc.nextLine();

            switch (command) {
                case EXIT:
                    isRunning = false;
                    System.out.println("The program was terminated.");
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_BY_ID:
                    changeDoctorById();
                    break;
                case ADD_PATIENT:
                    addPatient();
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    printAllPatientsByDoctor();
                    break;
                case PRINT_ALL_PATIENTS:
                    printAllPatients();
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }

    private static void addDoctor() {
        System.out.println("Enter Doctor Name:");
        String name = sc.nextLine();

        System.out.println("Enter Doctor Surname:");
        String surname = sc.nextLine();

        System.out.println("Enter Doctor ID:");
        String id = sc.nextLine();

        System.out.println("Enter Doctor's Phone Number:");
        String phoneNumber = sc.nextLine();

        Profession profession = null;
        while (profession == null) {
            System.out.println("Choose Doctor's Profession [OPHTHALMOLOGIST, OTOLARYNGOLOGIST, CARDIOLOGIST, DERMATOLOGIST, ORTHOPEDIC_SURGEON]:");
            String professionInput = sc.nextLine().toUpperCase();
            try {
                profession = Profession.valueOf(professionInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid profession. Please enter a valid one.");
            }
        }

        System.out.println("Enter Doctor's Email Address:");
        String email = sc.nextLine();
        Doctor doctor = new Doctor(name, surname, id, phoneNumber, profession, email);
        doctorStorage.add(doctor);
        System.out.println("The Doctor was added successfully.");
    }

    private static void searchDoctorByProfession() {
        System.out.println("Enter profession to search:");
        System.out.println("Choose from the following: [OPHTHALMOLOGIST, OTOLARYNGOLOGIST, CARDIOLOGIST, DERMATOLOGIST, ORTHOPEDIC_SURGEON]");
        String profession = sc.nextLine();
        try {
            doctorStorage.searchDoctorByProfession(profession);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid profession. Please enter a valid one.");
            System.out.println("Choose from the following: [OPHTHALMOLOGIST, OTOLARYNGOLOGIST, CARDIOLOGIST, DERMATOLOGIST, ORTHOPEDIC_SURGEON]");
            searchDoctorByProfession();
        } catch (ProfessionNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteDoctorById() {
        System.out.println("Enter Doctor ID to delete:");
        doctorStorage.print();
        String id = sc.nextLine();
        try {
            doctorStorage.deleteById(id);
            System.out.println("Doctor Deleted Successfully");
        } catch (IllegalIDException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeDoctorById() {
        System.out.println("Choose the Doctor to update their data except the ID");
        doctorStorage.print();
        System.out.println("Enter Doctor ID to change their data:");
        Doctor doctor = null;
        while (doctor == null) {
            String doctorId = sc.nextLine();
            try {
                doctor = doctorStorage.getByID(doctorId);
            } catch (IllegalIDException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter new name to update Doctor's name");
        String name = sc.nextLine();
        doctor.setName(name);
        System.out.println("Enter new surname to update Doctor's surname");
        String surname = sc.nextLine();
        doctor.setSurname(surname);
        System.out.println("Enter new phone number to update Doctor's Phone Number:");
        String phoneNumber = sc.nextLine();
        doctor.setPhoneNumber(phoneNumber);
        System.out.println("Enter new profession to update Doctor's Profession");
        System.out.println("Choose Doctor's Profession [OPHTHALMOLOGIST, OTOLARYNGOLOGIST, CARDIOLOGIST, DERMATOLOGIST, ORTHOPEDIC_SURGEON]:");
        Profession profession = Profession.valueOf(sc.nextLine().toUpperCase());
        doctor.setProfession(profession);
        System.out.println("Enter new email to update Doctor's Email Address:");
        String email = sc.nextLine();
        doctor.setEmail(email);
        System.out.println("Doctor updated successfully.");
    }

    private static void addPatient() {
        System.out.println("Choose the Doctor to assign the Patient");
        doctorStorage.print();
        System.out.println("Enter the Doctor by pasting Doctor's ID");
        Doctor doctor = null;
        String doctorId = sc.nextLine();
        try {
            doctor = doctorStorage.getByID(doctorId);
        } catch (IllegalIDException e) {
            System.out.println(e.getMessage());
            addPatient();
        }

        System.out.println("Enter Patient Name:");
        String name = sc.nextLine();

        System.out.println("Enter Patient Surname:");
        String surname = sc.nextLine();

        System.out.println("Enter Patient ID:");
        String id = sc.nextLine();

        System.out.println("Enter Patient's Phone Number:");
        String phoneNumber = sc.nextLine();

        System.out.println("Enter The Registration Date (dd-MM-yyyy):");
        Date registrationDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        while (registrationDate == null) {
            String dateInput = sc.nextLine();
            try {
                registrationDate = formatter.parse(dateInput);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter in dd-MM-yyyy format:");
            }
        }

        Patient patient = new Patient(name, surname, id, phoneNumber, doctor, registrationDate);
        patientStorage.add(patient);
        System.out.println("The Patient was added successfully.");
    }

    private static void printAllPatientsByDoctor() {
        System.out.println("Choose the Doctor to view all their Patients");
        doctorStorage.print();
        System.out.println("Enter the Doctor by pasting Doctor's ID");
        Doctor doctor = null;
        String doctorId = sc.nextLine();
        try {
            doctor = doctorStorage.getByID(doctorId);
        } catch (IllegalIDException e) {
            System.out.println(e.getMessage());
        }
        patientStorage.printAllPatientsByDoctor(doctor);
    }

    private static void printAllPatients() {
        patientStorage.print();
    }
}