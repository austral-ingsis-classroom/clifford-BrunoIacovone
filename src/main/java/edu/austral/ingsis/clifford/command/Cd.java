package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Si;
import edu.austral.ingsis.clifford.fileSystem.Dir;
import edu.austral.ingsis.clifford.fileSystem.FileSystem;

import java.util.List;

public class Cd implements Command{
    private Si si;
    private String path;

    public Cd(String path) {
        this.si = Si.getInstance();
        this.path = path;
    }

    @Override
    public String execute() {
        Dir current = si.getCurrentDir();
        if (path.charAt(0) == '/') {
            current = si.getRoot();
        }
        String[] pathParts = path.split("/");
        for (String part : pathParts) {
            if (part.equals("..")) {
                if (current.getParent() != null) {
                    current = current.getParent();
                }
            } else {
                List<FileSystem> files = current.getContent();
                boolean found = false;
                for (FileSystem dir : files) {
                    if (dir.getName().equals(part) && dir instanceof Dir) {
                        current = (Dir) dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return "'" + part + "' directory does not exist";
                }
            }
        }
        si.setCurrentDir(current);
        return "moved to directory '" + current.getName() + "'";
    }
}
