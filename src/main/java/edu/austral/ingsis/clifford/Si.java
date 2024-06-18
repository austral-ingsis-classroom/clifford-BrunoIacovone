package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.builders.*;
import edu.austral.ingsis.clifford.fileSystem.Dir;
import java.util.Map;

public class Si {
  private Dir root = new Dir("/", null);
  private Dir currentDir = root;
  private static final Si instance = new Si();

  public static Si getInstance() {
    return instance;
  }

  public final Map<String, CommandBuilder> commandBuilders =
      Map.of(
          "rm", new RMCommandBuilder(),
          "ls", new LsCommandBuilder(),
          "cd", new CdCommandBuilder(),
          "touch", new TouchCommandBuilder(),
          "mkdir", new MkdirCommandBuilder(),
          "pwd", new PwdCommandBuilder());

  public Dir getRoot() {
    return root;
  }

  public Dir getCurrentDir() {
    return currentDir;
  }

  public void setCurrentDir(Dir currentDir) {
    this.currentDir = currentDir;
  }

  public String execute(String command) {
    String[] split = command.split(" ");
    return commandBuilders.get(split[0]).buildCommand(command).execute();
  }

  public void clear() {
    root = new Dir("/", null);
    currentDir = root;
  }
}
