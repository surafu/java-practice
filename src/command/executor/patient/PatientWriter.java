package src.command.executor.patient;

import src.Doctor;
import src.Patient;
import src.command.CommandType;
import src.command.executor.AbstractCommandExecutor;

import java.util.Set;

public class PatientWriter extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return writeAllPatients(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_PATIENTS;
    }

    private int writeAllPatients(String command) {
        Set<Patient> patients = patientRepository.getAllPatients();
        for(Patient patient: patients) {
            System.out.println(patient.getID() + " " + patient.getName() + " " + patient.getRegistrationDate());
        }
        return 1;
    }
}