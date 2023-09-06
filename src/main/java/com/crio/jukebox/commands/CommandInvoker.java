package com.crio.jukebox.commands;

import java.util.*;

public class CommandInvoker {
    private static final Map<String, ICommand> commands = new HashMap<String, ICommand>();

    public void register(String commandName, ICommand command){
        commands.put(commandName, command);
    }
    public ICommand get(String commandName){
        return commands.get(commandName);
    }
    public void executeCommand(String commandName, List<String> tokens) throws Exception{
        ICommand command = get(commandName);
        command.execute(tokens);
    }
}
