package medicalCenter.patient;

import medicalCenter.Person;
import medicalCenter.doctor.Doctor;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person {

    private Doctor doctor;
    private Date registrationDate;

    public Patient(String name, String surname, String id, String phoneNumber, Doctor doctor, Date registrationDate) {
        super(name, surname, id, phoneNumber);
        this.doctor = doctor;
        this.registrationDate = registrationDate;
    }

    public Patient(String name, String surname, String id, String phoneNumber) {
        super(name, surname, id, phoneNumber);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(doctor, patient.doctor) && Objects.equals(registrationDate, patient.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doctor, registrationDate);
    }

    @Override
    public String toString() {
        return "Patient{" + super.toString() +
                "doctor=" + doctor +
                ", registrationDate=" + registrationDate +
                '}';
    }
}