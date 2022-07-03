package src.repository.impl;

import src.Patient;
import src.repository.PatientRepository;

import java.util.HashSet;
import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {

    private static final Set<Patient> PATIENTS = new HashSet<>();

    private static final PatientRepositoryImpl SINGLETON = new PatientRepositoryImpl();

    private PatientRepositoryImpl() {}

    public static PatientRepository getSingleton() {
        return SINGLETON;
    }
    @Override
    public Set<Patient> getAllPatients() {
        return PATIENTS;
    }

    @Override
    public void save(Patient patient) {
        PATIENTS.add(patient);
    }

    @Override
    public void remove(Patient patient) {
        PATIENTS.remove(patient);
    }

    public void change(Patient patient, String newName) {
        PATIENTS.remove(patient);
        patient.setName(newName);
        save(patient);
    }
}
