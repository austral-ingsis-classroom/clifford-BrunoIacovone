package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Si;
import edu.austral.ingsis.clifford.fileSystem.Dir;

public class Pwd implements Command {

  private final Si si;

  public Pwd() {
    this.si = Si.getInstance();
  }

  @Override
  public String execute() {
    Dir current = si.getCurrentDir();
    if (current.getName().equals("/")) {
      return "/";
    } else {
      StringBuilder result = new StringBuilder();
      while (!current.getName().equals("/")) {
        result.insert(0, "/" + current.getName());
        current = current.getParent();
      }
      return result.toString();
    }
  }
}
