package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Si;
import edu.austral.ingsis.clifford.fileSystem.Dir;
import edu.austral.ingsis.clifford.fileSystem.FileSystem;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Ls implements Command {
  private final Si si;
  private final Boolean order;

  public Ls(Boolean order) {
    this.si = Si.getInstance();
    this.order = order;
  }

  @Override
  public String execute() {
    Dir current = si.getCurrentDir();
    if (order == null) {
      return current.getContent().stream()
          .map(FileSystem::getName)
          .collect(Collectors.joining(" "));
    }
    if (order) {
      return current.getContent().stream()
          .map(FileSystem::getName)
          .sorted(Comparator.naturalOrder())
          .collect(Collectors.joining(" "));
    } else {
      return current.getContent().stream()
          .map(FileSystem::getName)
          .sorted(Comparator.reverseOrder())
          .collect(Collectors.joining(" "));
    }
  }
}
