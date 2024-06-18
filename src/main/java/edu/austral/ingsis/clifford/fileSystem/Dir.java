package edu.austral.ingsis.clifford.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class Dir implements FileSystem {
    String name;
    String creator;
    List<FileSystem> content;
    Dir parent;

    public Dir(String name, String creator, Dir parent) {
        this.name = name;
        this.creator = creator;
        this.content = new ArrayList<>();
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

    public void add(FileSystem file) {
        content.add(file);
    }

    public void remove(String file){
        content.removeIf(f -> f.getName().equals(file));
    }

    public FileSystem get(String file){
        return content.stream().filter(f -> f.getName().equals(file)).findFirst().orElse(null);
    }

    public List<FileSystem> getContent() {
        return content;
    }
}
