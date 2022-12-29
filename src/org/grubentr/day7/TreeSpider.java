package org.grubentr.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TreeSpider {
    public static List<Dir> findDir(List<Dir> acc, Dir root, Predicate<Dir> p) {
        if (p.test(root)) {
            acc.add(root);
        }

        for (Dir child : root.getChildren()) {
            findDir(acc, child, p);
        }

        return acc;
    }
}
