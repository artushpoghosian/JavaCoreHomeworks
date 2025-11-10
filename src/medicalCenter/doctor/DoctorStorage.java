package medicalCenter.doctor;

import medicalCenter.Profession;
import medicalCenter.exception.IllegalIDException;
import medicalCenter.exception.ProfessionNotFoundException;

public class DoctorStorage {

    private Doctor[] doctors = new Doctor[25];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(Doctor doctor) {
        if (size == doctors.length) extend();
        doctors[size++] = doctor;
    }

    private void extend() {
        Doctor[] temp = new Doctor[size + 10];
        System.arraycopy(doctors, 0, temp, 0, size);
        doctors = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }

    public void searchDoctorByProfession(String profession) throws ProfessionNotFoundException, IllegalArgumentException {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession() == Profession.valueOf(profession.toUpperCase())) {
                System.out.println(doctors[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProfessionNotFoundException("No Doctor with the '" + profession + "' profession was found");
        }
    }

    public void deleteById(String id) throws IllegalIDException, IllegalArgumentException {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    doctors[j] = doctors[j + 1];
                }
            }
            size--;
            found = true;
        }
        if (!found)
            throw new IllegalIDException("No Doctor with the '" + id + "' id was found");
    }

    public Doctor getByID(String id) throws IllegalIDException {
        for (int i = 0; i < size; i++) {
            if(doctors[i].getId().equals(id)){
                return doctors[i];
            }
        }
        throw new IllegalIDException("No Doctor with the '" + id + "' id was found");
    }
}

