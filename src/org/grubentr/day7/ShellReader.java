package org.grubentr.day7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShellReader {
    private final Dir root = new Dir();
    private Dir cwd = root;

    private static final String LS = "$ ls";
    private static final String CD_ROOT = "$ cd /";
    private static final String CD_PARENT = "$ cd ..";
    private static final String CD_PREFIX = "$ cd ";
    private static final String DIR_PREFIX = "dir ";


    public Dir getRoot() {
        return this.root;
    }

    public void parse(String line) {
        if (line.equals(LS)) {
            return;
        }

        else if (line.equals(CD_ROOT)) {
            cwd = root;
        }

        else if (line.equals(CD_PARENT)) {
            cwd = cwd.parent();
        }

        else if (line.startsWith(CD_PREFIX)) {
            String childDir = line.substring(CD_PREFIX.length());
            cwd = cwd.getDir(childDir);
        }

        else if (line.startsWith(DIR_PREFIX)) {
            String childDir = line.substring(DIR_PREFIX.length());
            cwd.addDir(childDir);
        }

        else {
            Pattern fileRegex = Pattern.compile("(?<size>[0-9]+) (?<filename>.*)");
            Matcher matcher = fileRegex.matcher(line);
            matcher.find();
            long size = Long.parseLong(matcher.group("size"));
            String filename = matcher.group("filename");
            cwd.addFile(filename, size);
        }
    }
}
