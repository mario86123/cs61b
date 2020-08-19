public class BubbleGrid {
    private int[][] grid;
    private int numOfRows;
    private int numOfCols;

    /* Create new BubbleGrid with bubble/space locations specified by grid.
     * Grid is composed of only 1's and 0's, where 1's denote a bubble, and
     * 0's denote a space. */
    public BubbleGrid(int[][] grid) {
        this.grid = grid;
        numOfRows = grid.length;
        numOfCols = grid[0].length;
    }

    private int topUnionSize(int tmp[][]) {
        int root = -1;
        UnionFind uf = new UnionFind(numOfRows * numOfCols);

        for (int i = 0; i < numOfCols && root < 0; i += 1) {
            if (tmp[0][i] == 1) {
                root = id(0, i);
            }
        }
        if (root < 0) {
            return 0;
        }
        for (int i = 0; i < numOfCols; i += 1) {
            if (tmp[0][i] == 1) {
                uf.union(root, id(0, i));
            }
        }

        for (int i = 0; i < numOfRows; i += 1) {
            for (int j = 0; j < numOfCols; j += 1) {
                if (tmp[i][j] == 1) {
                    if ((i+1) < numOfRows && tmp[i+1][j] == 1) {
                        uf.union(id(i, j), id(i+1, j));
                    }
                    if ((j+1) < numOfCols && tmp[i][j+1] == 1) {
                        uf.union(id(i, j), id(i, j+1));
                    }
                }
            }
        }
        return uf.sizeOf(root);
    }

    private int id(int row, int col) {
        return row * numOfCols + col;
    }

    /* Returns an array whose i-th element is the number of bubbles that
     * fall after the i-th dart is thrown. Assume all elements of darts
     * are unique, valid locations in the grid. Must be non-destructive
     * and have no side-effects to grid. */
    public int[] popBubbles(int[][] darts) {
        // TODO
        int numOfDarts = darts.length;
        int[] ans = new int[numOfDarts];
        int oldTopUnionSize = topUnionSize(grid);

        if (oldTopUnionSize == 0) {
            for (int i = 0; i < numOfDarts; i+=1) {
                ans[i] = 0;
            }
            return ans;
        }

        for (int i = 0; i < numOfDarts; i+=1) {

            if (grid[darts[i][0]][darts[i][1]] == 0) {
                ans[i] = 0;
            } else {
                int[][] afterDart = new int[numOfRows][numOfCols];
                for (int j = 0; j < numOfRows; j += 1) {
                    for (int k = 0; k < numOfCols; k += 1) {
                        afterDart[j][k] = grid[j][k];
                    }
                }
                afterDart[darts[i][0]][darts[i][1]] = 0;

                ans[i] = oldTopUnionSize - topUnionSize(afterDart) - 1;
            }
        }
        return ans;
    }
}
