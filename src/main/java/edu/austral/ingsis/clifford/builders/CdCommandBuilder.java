package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.command.Cd;
import edu.austral.ingsis.clifford.command.Command;

public class CdCommandBuilder implements CommandBuilder {
  @Override
  public Command buildCommand(String command) {
    String path = command.split(" ")[1];
    return new Cd(path);
  }
}
