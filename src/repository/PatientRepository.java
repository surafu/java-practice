package src.repository;

import src.Doctor;
import src.Patient;

import java.util.Set;

public interface PatientRepository {

    Set<Patient> getAllPatients();

    void save(Patient patient);

    void remove(Patient patient);

    void change(Patient patient, String newName);
}
