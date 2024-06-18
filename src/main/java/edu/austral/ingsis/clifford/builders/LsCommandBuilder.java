package edu.austral.ingsis.clifford.builders;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.Ls;

public class LsCommandBuilder implements CommandBuilder{
    @Override
    public Command buildCommand(String command) {
        Boolean res;
        String[] commando = command.split(" ");
        if (commando.length > 1){
            String order = commando[1];
            if (order.equals("--ord=asc")) {
                res = true;
            }
            else if (order.equals("--ord=desc")) {
                res = false;
            }
            else res = null;
        }
        else {
            res = null;
        }
        return new Ls(res);
    }
}
