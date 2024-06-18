package edu.austral.ingsis.clifford.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class Dir implements FileSystem {
    String name;
    List<FileSystem> content;
    Dir parent;

    public Dir(String name, Dir parent) {
        this.name = name;
        this.content = new ArrayList<>();
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

    public void add(FileSystem file) {
        content.add(file);
    }

    public void remove(String file){
        content.removeIf(f -> f.getName().equals(file) && f instanceof File);
    }

    public void removeRecursive(String dir){
        FileSystem toRemove = content.stream().filter(f -> f.getName().equals(dir)).findFirst().orElse(null);
        if (toRemove != null){
            content.remove(toRemove);
        }
        else {
            for (FileSystem f : content){
                if (f instanceof Dir){
                    ((Dir) f).removeRecursive(dir);
                }
            }
        }
    }

    public FileSystem get(String file){
        return content.stream().filter(f -> f.getName().equals(file)).findFirst().orElse(null);
    }

    public List<FileSystem> getContent() {
        return content;
    }
}
