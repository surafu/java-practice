package src.command;

import src.command.executor.CommandExecutor;
import src.command.executor.doctor.DoctorCreator;
import src.command.executor.patient.*;

import java.util.Map;
import java.util.Scanner;

public class CommandReader {

    private static final  Map<CommandType, CommandExecutor> COMMAND_EXECUTORS_GROUPED_BY_COMMAND = Map.of(
            CommandType.CREATE_PATIENT, new PatientCreator(),
            CommandType.CHANGE_PATIENT, new PatientChanger(),
            CommandType.DELETE_PATIENT, new PatientDeleter(),
            CommandType.WRITE_ALL_PATIENTS, new PatientWriter(),
            CommandType.CREATE_DOCTOR, new DoctorCreator()
    );

    public static void startReading() {
        Scanner s = new Scanner(System.in);

        int i = 1;
        while (i != 0) {
            try {
                i = readCommand(s);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        s.close();
    }

    private static int readCommand(Scanner s) {
        var commandString = s.nextLine();

        CommandType commandType = getCommandType(commandString); // достаем из строки команду.

        if (COMMAND_EXECUTORS_GROUPED_BY_COMMAND.containsKey(commandType)) { // проверяем, есть ли обработчик этой команды в мапе по ключу.
            var commandExecutor = COMMAND_EXECUTORS_GROUPED_BY_COMMAND.get(commandType); // если есть, то достаем обработчик по ключу
            return commandExecutor.execute(commandString); // и выполняем команду
        }

        if (commandType == CommandType.EXIT) {
            return 0;
        }

        System.out.println("Incorrect command");
        return -1;
    }

    private static CommandType getCommandType(String commandString) {
        if (commandString.contains("create patient")) {
            return CommandType.CREATE_PATIENT;
        }

        if (commandString.contains("change patient")) {
            return CommandType.CHANGE_PATIENT;
        }

        if (commandString.contains("delete patient")) {
            return CommandType.DELETE_PATIENT;
        }

        if (commandString.contains("write all patients")) {
            return CommandType.WRITE_ALL_PATIENTS;
        }

        if (commandString.contains("create doctor")) {
            return CommandType.CREATE_DOCTOR;
        }

        return CommandType.UNDEFINED;
    }
}
