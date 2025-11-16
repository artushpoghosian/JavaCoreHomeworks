package medicalCenter.patient;

import medicalCenter.doctor.Doctor;

import java.io.Serializable;

public class PatientStorage implements Serializable {
    private Patient[] patients = new Patient[50];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(Patient patient) {
        if (size == patients.length) extend();
        patients[size++] = patient;
    }

    private void extend() {
        Patient[] temp = new Patient[size + 30];
        System.arraycopy(patients, 0, temp, 0, size);
        patients = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i]);
        }
    }

    public void printAllPatientsByDoctor(Doctor doctor) {
        for (int i = 0; i < size; i++) {
            if(patients[i].getDoctor().equals(doctor))
                System.out.println(patients[i]);
        }
    }
}