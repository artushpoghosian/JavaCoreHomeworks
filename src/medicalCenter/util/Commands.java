package medicalCenter.util;

public interface Commands {
    String EXIT = "0";
    String ADD_DOCTOR = "1";
    String SEARCH_DOCTOR_BY_PROFESSION = "2";
    String DELETE_DOCTOR_BY_ID = "3";
    String CHANGE_DOCTOR_BY_ID = "4";
    String ADD_PATIENT = "5";
    String PRINT_ALL_PATIENTS_BY_DOCTOR= "6";
    String PRINT_ALL_PATIENTS = "7";

    static void printCommands() {
        System.out.println("Please input " + EXIT + " to EXIT");
        System.out.println("Please input " + ADD_DOCTOR + " to ADD A DOCTOR");
        System.out.println("Please input " + SEARCH_DOCTOR_BY_PROFESSION + " to SEARCH A DOCTOR BY PROFESSION");
        System.out.println("Please input " + DELETE_DOCTOR_BY_ID + " to DELETE A DOCTOR BY ID");
        System.out.println("Please input " + CHANGE_DOCTOR_BY_ID + " to CHANGE A DOCTOR BY ID");
        System.out.println("Please input " + ADD_PATIENT + " to ADD A PATIENT");
        System.out.println("Please input " + PRINT_ALL_PATIENTS_BY_DOCTOR + " to PRINT ALL PATIENTS BY DOCTOR");
        System.out.println("Please input " + PRINT_ALL_PATIENTS + " to PRINT ALL PATIENTS");
    }
}