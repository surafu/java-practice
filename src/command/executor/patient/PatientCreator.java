package src.command.executor.patient;

import src.Doctor;
import src.Patient;
import src.command.CommandType;
import src.command.executor.AbstractCommandExecutor;

public class PatientCreator  extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return createPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_PATIENT;
    }

    private int createPatient(String command) {
        var wordsArray = command.split(" ");

        StringBuilder patientNameSb = new StringBuilder();
        for (int i = 0; i + 2 < wordsArray.length; i++) {
            patientNameSb.append(wordsArray[i + 2]);
        }

        var newPatient = new Patient(patientNameSb.toString());

        patientRepository.save(newPatient);

        System.out.println("New patient created. Unique ID: " + newPatient.getID());

        return 1;
    }
}
