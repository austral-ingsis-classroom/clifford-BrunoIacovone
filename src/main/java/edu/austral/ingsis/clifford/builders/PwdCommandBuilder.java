package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.Pwd;

public class PwdCommandBuilder implements CommandBuilder{
    @Override
    public Command buildCommand(String command) {
        return new Pwd();
    }
}
