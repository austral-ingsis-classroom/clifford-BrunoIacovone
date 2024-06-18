package edu.austral.ingsis.clifford.fileSystem;

public class File implements FileSystem {
  String name;
  Dir parent;

  public File(String name, Dir parent) {
    this.name = name;
    this.parent = parent;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Dir getParent() {
    return parent;
  }
}
