package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Si;
import edu.austral.ingsis.clifford.fileSystem.Dir;

public class Remove implements Command{

    private String file;
    private Dir currentDir;

    public Remove(String file){
        this.file = file;
        this.currentDir = Si.getInstance().getCurrentDir();
    }

    @Override
    public String execute() {
        currentDir.remove(file);
        return "";
    }
}
