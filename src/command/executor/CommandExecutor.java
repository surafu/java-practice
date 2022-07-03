package src.command.executor;

import src.command.CommandType;

public interface CommandExecutor {

    int execute(String command);

    CommandType getCommandType();
}
