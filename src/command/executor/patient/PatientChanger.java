package src.command.executor.patient;

import src.command.CommandType;
import src.command.executor.AbstractCommandExecutor;

import java.util.Scanner;

public class PatientChanger extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return changePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CHANGE_PATIENT;
    }

    private int changePatient(String command) {
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


        Scanner s = new Scanner(System.in);

        System.out.println("Enter a new name: ");

        patientRepository.change(patient, s.nextLine());

        System.out.println("Patient " + patientID + " name has been changed from " + patientName + " to " + patient.getName());

        return 1;
    }
}