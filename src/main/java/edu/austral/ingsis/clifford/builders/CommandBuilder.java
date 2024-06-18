package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.command.Command;

public interface CommandBuilder {
  Command buildCommand(String command);
}
