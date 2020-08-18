public class BubbleGrid {
    private int[][] grid;

    /* Create new BubbleGrid with bubble/space locations specified by grid.
     * Grid is composed of only 1's and 0's, where 1's denote a bubble, and
     * 0's denote a space. */
    public BubbleGrid(int[][] grid) {
        this.grid = grid;
    }

    private int topUnionSize(int tmp[][]) {

        return ;
    }

    /* Returns an array whose i-th element is the number of bubbles that
     * fall after the i-th dart is thrown. Assume all elements of darts
     * are unique, valid locations in the grid. Must be non-destructive
     * and have no side-effects to grid. */
    public int[] popBubbles(int[][] darts) {
        // TODO
        int numOfRows = grid.length;
        int numOfCols = grid[0].length;
        int numOfDarts = darts.length;
        int[] ans = new int[numOfDarts];

        UnionFind uf = new UnionFind(numOfRows * numOfCols);

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

                ans[i] = topUnionSize(grid) - topUnionSize(afterDart);
                // wrong thought, maybe dart is also in the top union
            }
        }
        return ans;
    }
}
