package medicalCenter.doctor;

import medicalCenter.Person;
import medicalCenter.Profession;

import java.util.Objects;

public class Doctor extends Person {

    private Profession profession;
    private String email;

    public Doctor(String name, String surname, String id, String phoneNumber, Profession profession, String email) {
        super(name, surname, id, phoneNumber);
        this.profession = profession;
        this.email = email;
    }

    public Doctor(String name, String surname, String id, String phoneNumber) {
        super(name, surname, id, phoneNumber);
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(profession, doctor.profession) && Objects.equals(email, doctor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), profession, email);
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString() +
                ", profession='" + profession + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}