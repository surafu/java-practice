package src;

import src.command.CommandReader;
import src.command.executor.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        if (auth.getAuthSuccess() == 0) {
            System.out.println("You are logged in as " + auth.getUsername());
        } else {
            System.out.println("Login failed");
        }

        CommandReader.startReading();
    }
}
