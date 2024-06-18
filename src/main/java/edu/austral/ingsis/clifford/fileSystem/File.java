package edu.austral.ingsis.clifford.fileSystem;

public class File implements FileSystem {
    String name;
    String creator;
    Dir parent;

    public File(String name, String creator, Dir parent) {
        this.name = name;
        this.creator = creator;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    public Dir getParent() {
        return parent;
    }
}
