package src.command.executor.doctor;

import src.Doctor;
import src.command.CommandType;
import src.command.executor.AbstractCommandExecutor;

public class DoctorCreator  extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return createDoctor(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_DOCTOR;
    }

    private int createDoctor(String command) {
        var wordsArray = command.split(" ");

        StringBuilder doctorNameSb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            doctorNameSb.append(wordsArray[i + 2]);
        }

        StringBuilder doctorSpecSb = new StringBuilder();
        for (int i = 0; i + 5 < wordsArray.length; i++) {
            doctorSpecSb.append(wordsArray[i + 5]);
        }

        var newDoctor = new Doctor(doctorNameSb.toString(), doctorSpecSb.toString());

        doctorRepository.save(newDoctor);

        System.out.println("New doctor created. Unique ID: " + newDoctor.getID());

        return 1;
    }
}
