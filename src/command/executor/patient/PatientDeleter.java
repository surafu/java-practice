package src.command.executor.patient;

import src.command.CommandType;
import src.command.executor.AbstractCommandExecutor;

public class PatientDeleter extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return deletePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_PATIENT;
    }

    private int deletePatient(String command) {
        var wordsArray = command.split(" ");

        var patientID = Integer.parseInt(wordsArray[2]);

        StringBuilder patientNameSb = new StringBuilder();
        for (int i = 0; i + 3 < wordsArray.length; i++) {
            patientNameSb.append(wordsArray[i + 3]);
        }

        var patientName = patientNameSb.toString();

        var patient = findPatient(patientName, patientID);
        if (patient == null) {
            return 0;
        }
        patientRepository.remove(patient);
        return 1;
    }
}
