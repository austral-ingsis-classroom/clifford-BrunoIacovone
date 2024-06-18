package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.Touch;

public class TouchCommandBuilder implements CommandBuilder {

  @Override
  public Command buildCommand(String command) {
    String file = command.split(" ")[1];
    return new Touch(file);
  }
}
