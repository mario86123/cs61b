import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleGridTest {

    @Test
    public void testBasic() {

        int[][] grid = {{1, 0, 0, 0},
                        {1, 1, 1, 0}};
        int[][] darts = {{1, 0}, {1, 2}, {0, 0}};
        int[] expected = {2, 0, 3};

        validate(grid, darts, expected);

        int[][] grid1 = {{1, 1, 0},
                         {1, 0, 0},
                         {1, 1, 0},
                         {1, 1, 1}};
        int[][] darts1 = {{1, 0}};
        int[] expected1 = {5};

        validate(grid1, darts1, expected1);

        int[][] darts2 = {{2, 2}, {2, 0}};
        int[] expected2 = {0, 4};

        validate(grid1, darts2, expected2);

        int[][] grid3 = {{1, 1, 0},
                         {0, 1, 1},
                         {1, 1, 0},
                         {0, 1, 1}};
        int[][] darts3 = {{1, 1}};
        int[] expected3 = {5};
        validate(grid3, darts3, expected3);

        int[][] grid4 = {{1, 1, 0, 1},
                         {0, 1, 0, 1},
                         {1, 1, 0, 1},
                         {0, 1, 0, 1}};
        int[][] darts4 = {{1, 1}, {2, 3}, {2, 1}};
        int[] expected4 = {3, 1, 2};
        validate(grid4, darts4, expected4);

        int[][] grid5 = {{0, 0, 0, 0},
                         {0, 0, 0, 0}};
        int[][] darts5 = {{1, 1}};
        int[] expected5 = {0};
        validate(grid5, darts5, expected5);

        int[][] grid6 = {{1, 1, 1, 0},
                         {0, 0, 1, 1},
                         {0, 1, 0, 1},
                         {1, 1, 1, 1}};
        int[][] darts6 = {{1, 2}};
        int[] expected6 = {7};
        validate(grid6, darts6, expected6);
    }

    private void validate(int[][] grid, int[][] darts, int[] expected) {
        BubbleGrid sol = new BubbleGrid(grid);
        assertArrayEquals(expected, sol.popBubbles(darts));
    }
}
