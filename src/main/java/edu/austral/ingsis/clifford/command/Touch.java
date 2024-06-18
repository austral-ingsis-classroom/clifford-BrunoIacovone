package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Si;
import edu.austral.ingsis.clifford.fileSystem.Dir;
import edu.austral.ingsis.clifford.fileSystem.File;

public class Touch implements Command {
  private final String fileName;
  private final Si si;

  public Touch(String fileName) {
    this.fileName = fileName;
    this.si = Si.getInstance();
  }

  @Override
  public String execute() {
    Dir current = si.getCurrentDir();
    current.getContent().removeIf(file -> file.getName().equals(fileName) && file instanceof File);
    current.add(new File(fileName, current));
    return "'" + fileName + "' file created";
  }
}
