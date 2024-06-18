package edu.austral.ingsis;

import edu.austral.ingsis.clifford.Si;
import edu.austral.ingsis.clifford.builders.CommandBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyFileSystemRunner implements FileSystemRunner {
  private final Si si;

  public MyFileSystemRunner() {
    this.si = Si.getInstance();
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    si.clear();
    List<String> result = new ArrayList<>();
    Map<String, CommandBuilder> map = si.commandBuilders;
    for (String command : commands) {
      String[] split = command.split(" ");
      result.add(map.get(split[0]).buildCommand(command).execute());
    }
    return result;
  }
}
