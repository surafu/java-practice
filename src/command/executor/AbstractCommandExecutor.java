package src.command.executor;

import src.Doctor;
import src.Patient;
import src.repository.DoctorRepository;
import src.repository.PatientRepository;
import src.repository.impl.DoctorRepositoryImpl;
import src.repository.impl.PatientRepositoryImpl;

public abstract class AbstractCommandExecutor implements CommandExecutor {

    protected final PatientRepository patientRepository = PatientRepositoryImpl.getSingleton();

    protected final DoctorRepository doctorRepository = DoctorRepositoryImpl.getSingleton();

    protected Patient findPatient(String patientName, int ID) {
        for (Patient patient : patientRepository.getAllPatients()) {
            if (patient.getName().equals(patientName) && patient.getID() == ID) {
                return patient;
            }
        }
        return null;
    }
}
