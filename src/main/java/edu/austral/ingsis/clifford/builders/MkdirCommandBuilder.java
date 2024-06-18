package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.Mkdir;

public class MkdirCommandBuilder implements CommandBuilder {
  @Override
  public Command buildCommand(String command) {
    String dir = command.split(" ")[1];
    return new Mkdir(dir);
  }
}
