package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Si;
import edu.austral.ingsis.clifford.fileSystem.Dir;
import edu.austral.ingsis.clifford.fileSystem.File;
import edu.austral.ingsis.clifford.fileSystem.FileSystem;

public class Remove implements Command{

    private final String file;
    private final Dir currentDir;
    private boolean isRecursive;

    public Remove(String file, boolean isRecursive){
        this.file = file;
        this.isRecursive = isRecursive;
        this.currentDir = Si.getInstance().getCurrentDir();
    }

    @Override
    public String execute() {
        FileSystem file = currentDir.get(this.file);
        if (!isRecursive){
            if (file instanceof File) {
                currentDir.remove(file.getName());
                return "'"+file.getName()+"' removed";
            } else {
                return "cannot remove '"+file.getName()+"', is a directory";
            }
        }
        else {
            currentDir.removeRecursive(file.getName());
            return "'"+file.getName()+"' removed";
        }

    }
}
