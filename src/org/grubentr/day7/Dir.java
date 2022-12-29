package org.grubentr.day7;

import java.util.*;

public class Dir {
    private final String name;
    private final Dir parent;
    private long size;

    private final Map<String, Dir> subdirs = new HashMap<>();
    private final Map<String, File> files = new HashMap<>();

    private boolean touched = false;

    public Dir() {
        this.name = ""; // root
        this.parent = this;
    }

    public Dir(String name, Dir parent) {
        this.name = name;
        this.parent = parent;
    }

    public long size() {
        return this.size;
    }

    public Dir parent() {
        return this.parent;
    }

    public String name() {
        return this.name;
    }

    public void addDir(String name) {
        subdirs.put(name, new Dir(name, this));
    }

    public Dir getDir(String name) {
        return subdirs.get(name);
    }

    public Collection<Dir> getChildren() {
        return subdirs.values();
    }

    public void addFile(String name, long size) {
        files.put(name, new File(name, size, this));
    }

    /**
     * Recursively calculate the size of the contents of this directory.
     */
    public void calcSizes() {
        if (this.touched) return;

        for (Dir subdir : subdirs.values()) {
            subdir.calcSizes();
            this.size += subdir.size();
        }
        for (File file : files.values()) {
            this.size += file.size();
        }

        this.touched = true;
    }
}
