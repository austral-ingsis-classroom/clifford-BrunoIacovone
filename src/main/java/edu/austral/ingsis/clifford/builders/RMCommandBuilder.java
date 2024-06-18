package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.Remove;
import java.security.InvalidParameterException;

public class RMCommandBuilder implements CommandBuilder {
  @Override
  public Command buildCommand(String command) {
    String[] comando = command.split(" ");
    if (comando.length == 2) {
      return new Remove(comando[1], false);
    } else {
      if (comando[1].equals("--recursive")) {
        return new Remove(comando[2], true);
      }
    }
    throw new InvalidParameterException("Invalid command");
  }
}
