package src;

import src.repository.PatientRepository;
import src.repository.impl.PatientRepositoryImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Patient {

    private final int ID;

    private String name;

    private final String registrationDate;

    public Patient(String name) {

        this.name = name;

        Date dateNow = new Date();
        SimpleDateFormat formatNow = new SimpleDateFormat("yyyy-MM-dd");
        registrationDate = formatNow.format(dateNow);

        this.ID = getNewID();
    }

    private int getNewID() {
        PatientRepository patientRepository = PatientRepositoryImpl.getSingleton();
        Set<Patient> patients = patientRepository.getAllPatients();
        boolean idFound = false;
        int i = 1;
        while (!idFound) {
            idFound = true;
            for (Patient patient: patients) {
                if (patient.ID == i) {
                    idFound = false;
                    break;
                }
            }
            i++;
        }
        return i - 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public int getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name);
    }
}
