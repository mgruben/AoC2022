package org.grubentr.day8;


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
    }

    public int getNumVisibleFromOutside() {
        fromLeft();
        fromRight();
        fromTop();
        fromBottom();

        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visible[i][j]) count++;
            }
        }
        return count;
    }

    public long getHighestScenicScore() {
        long max = 0L;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                long score = getScore(i, j);
                if (score > max) max = score;
            }
        }
        return max;
    }

    private long getScore(int i, int j) {
        if (i == 0 || i == height - 1 ||
            j == 0 || j == width - 1) return 0;
        return lookUp(i, j) *
                lookDown(i, j) *
                lookLeft(i, j) *
                lookRight(i, j);
    }

    private long lookUp(int i, int j) {
        if (i == 1) return 1L;

        int numTrees = 1;
        int max = trees[i--][j];
        while (i > 0 && trees[i][j] < max) {
            i--;
            numTrees++;
        }

        return numTrees;
    }

    private long lookDown(int i, int j) {
        if (i == height - 2) return 1L;
        int numTrees = 1;
        int max = trees[i++][j];
        while (i < height - 1 && trees[i][j] < max) {
            i++;
            numTrees++;
        }

        return numTrees;
    }

    private long lookLeft(int i, int j) {
        if (j == 1) return 1L;
        int numTrees = 1;
        int max = trees[i][j--];
        while (j > 0 && trees[i][j] < max) {
            j--;
            numTrees++;
        }

        return numTrees;
    }

    private long lookRight(int i, int j) {
        if (j == width - 2) return 1L;
        int numTrees = 1;
        int max = trees[i][j++];
        while (j < width - 1 && trees[i][j] < max) {
            j++;
            numTrees++;
        }

        return numTrees;
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
