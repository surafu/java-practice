package src.repository;

import src.Doctor;
import java.util.Set;

public interface DoctorRepository {

    Set<Doctor> getAllDoctors();

    void save(Doctor doctor);
}
