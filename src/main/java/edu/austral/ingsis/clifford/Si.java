package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.builders.CommandBuilder;
import edu.austral.ingsis.clifford.builders.RMCommandBuilder;
import edu.austral.ingsis.clifford.fileSystem.Dir;

import java.util.Map;

public class Si {
    private final Dir root = new Dir("/", "root", null);
    private Dir currentDir = root;
    private static final Si instance = new Si();

    public static Si getInstance() {
        return instance;
    }

    public final Map<String, CommandBuilder> commandBuilders = Map.of(
            "rm", new RMCommandBuilder()
    );

    public Dir getRoot() {
        return (Dir) root;
    }

    public Dir getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(Dir currentDir) {
        this.currentDir = currentDir;
    }

    public String execute(String command) {
        String[] split = command.split(" ");
        return commandBuilders.get(split[0]).buildCommand(command).execute();
    }
}
