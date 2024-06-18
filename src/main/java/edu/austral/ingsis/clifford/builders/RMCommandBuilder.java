package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.Remove;

public class RMCommandBuilder implements CommandBuilder{
    @Override
    public Command buildCommand(String command) {
        String file = command.split(" ")[0];
        return new Remove(file);
    }
}
