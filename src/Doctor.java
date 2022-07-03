package src;

import src.repository.DoctorRepository;
import src.repository.impl.DoctorRepositoryImpl;

import java.util.Objects;
import java.util.Set;

public class Doctor {

    private final int ID;

    private String name;

    private final String specialization;

    public Doctor(String name, String specialization) {

        this.name = name;
        this.specialization = specialization;

        this.ID = getNewID();
    }

    private int getNewID() {
        DoctorRepository doctorRepository = DoctorRepositoryImpl.getSingleton();
        Set<Doctor> doctors = doctorRepository.getAllDoctors();
        boolean idFound = false;
        int i = 1;
        while (!idFound) {
            idFound = true;
            for (Doctor doctor: doctors) {
                if (doctor.ID == i) {
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

    public String getSpecialization() {
        return specialization;
    }

    public int getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor patient = (Doctor) o;
        return Objects.equals(name, patient.name);
    }
}
