package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Si;
import edu.austral.ingsis.clifford.fileSystem.Dir;
import edu.austral.ingsis.clifford.fileSystem.FileSystem;

public class Mkdir implements Command {
  private final String dir;
  private final Si si;

  public Mkdir(String dir) {
    this.dir = dir;
    this.si = Si.getInstance();
  }

  @Override
  public String execute() {
    Dir current = si.getCurrentDir();
    for (FileSystem elements : current.getContent()) {
      if (elements.getName().equals(dir) && elements instanceof Dir) {
        return "directory already exists";
      }
    }
    current.add(new Dir(dir, current));
    return "'" + dir + "' directory created";
  }
}
