package medicalCenter.util;

import medicalCenter.doctor.DoctorStorage;
import medicalCenter.patient.PatientStorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class FileUtil {

    private static final String DOCTOR_DATA_FILE = "C:\\Users\\lenovo\\Desktop\\JavaCoreHomeworks\\src\\medicalCenter\\data\\doctorData.data";
    private static final String PATIENT_DATA_FILE = "C:\\Users\\lenovo\\Desktop\\JavaCoreHomeworks\\src\\medicalCenter\\data\\patientData.data";

    public static void serializeDoctorData(DoctorStorage doctorStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DOCTOR_DATA_FILE))) {
            objectOutputStream.writeObject(doctorStorage);
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Doctor Data " + e);
        } catch (IOException e) {
            System.out.println("Failed to Serialize Doctor Data" + e);
        }
    }

    public static void serializePatientData(PatientStorage patientStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATIENT_DATA_FILE))) {
            objectOutputStream.writeObject(patientStorage);
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Patient Data " + e);
        } catch (IOException e) {
            System.out.println("Failed to Serialize Patient Data" + e);
        }
    }

    public static DoctorStorage deserializeDoctorData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DOCTOR_DATA_FILE))) {
            Object object = objectInputStream.readObject();
            if (object instanceof DoctorStorage doctorStorage) {
                return doctorStorage;
            }
        } catch (IOException e) {
            System.out.println("Failed to Deserialize Doctor Data" + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new DoctorStorage();
    }

    public static PatientStorage deserializePatientData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATIENT_DATA_FILE))) {
            Object object = objectInputStream.readObject();
            if (object instanceof PatientStorage patientStorage) {
                return patientStorage;
            }
        } catch (IOException e) {
            System.out.println("Failed to Deserialize Patient Data" + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new PatientStorage();
    }
}