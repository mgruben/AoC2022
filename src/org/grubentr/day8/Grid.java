package org.grubentr.day8;


import java.util.Arrays;

public class Grid {
    private final int[][] trees;
    private final boolean[][] visible;
    private final int height;
    private final int width;

    public Grid(int[][] trees) {
        this.trees = trees;
        this.height = trees.length;
        this.width = trees[0].length;
        this.visible = new boolean[height][width];

        fromLeft();
        fromRight();
        fromTop();
        fromBottom();
    }

    public int getNumVisible() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visible[i][j]) count++;
            }
        }
        return count;
    }


    private void fromLeft() {
        for (int i = 0; i < height; i++) {
            int max = -1;
            for (int j = 0; j < width; j++) {
                if (trees[i][j] > max) {
                    max = trees[i][j];
                    visible[i][j] = true;
                }
            }
        }
    }

    private void fromRight() {
        for (int i = 0; i < height; i++) {
            int max = -1;
            for (int j = width - 1; j >= 0; j--) {
                if (trees[i][j] > max) {
                    max = trees[i][j];
                    visible[i][j] = true;
                }
            }
        }
    }

    private void fromTop() {
        for (int j = 0; j < width; j++) {
            int max = -1;
            for (int i = 0; i < height; i++) {
                if (trees[i][j] > max) {
                    max = trees[i][j];
                    visible[i][j] = true;
                }
            }
        }
    }

    private void fromBottom() {
        for (int j = 0; j < width; j++) {
            int max = -1;
            for (int i = height - 1; i >= 0; i--) {
                if (trees[i][j] > max) {
                    max = trees[i][j];
                    visible[i][j] = true;
                }
            }
        }
    }
}
