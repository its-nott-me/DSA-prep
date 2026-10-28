/*
    Problem: Ninja and His Friends

    Goal:
    Two friends start from the first row:
    - Friend 1 starts at the first column.
    - Friend 2 starts at the last column.

    Both friends move down row by row until they reach
    the last row, collecting chocolates along the way.

    Allowed moves for each friend:
    - Down-Left  (r+1, c-1)
    - Down       (r+1, c)
    - Down-Right (r+1, c+1)

    Rules:
    - Both friends move simultaneously.
    - If both friends visit the same cell, its chocolates
      are counted only once.
    - Otherwise, both cells contribute to the total.

    DP meaning:
    dp[row][col1][col2] = maximum chocolates that can be
                          collected from the current row
                          to the last row when:
                          - Friend 1 is at col1.
                          - Friend 2 is at col2.

    Base Case:
    In the last row, no further moves are possible.
    Therefore:
    - If col1 == col2, count the cell only once.
    - Otherwise, add the chocolates from both cells.

    Transition:
    For every state (row, col1, col2):

    1. Calculate the current reward.
       If both friends are in the same cell, count it once.
       Otherwise, add both cell values.

    2. Try all 3 moves for Friend 1 and all 3 moves
       for Friend 2.

    3. Select the maximum valid future reward.

    4. Add the current reward to the best future reward.

    dp[row][col1][col2] =
        currentReward + bestFuture

    Answer:
    dp[0][0][cols-1]

    This represents the maximum chocolates collected when
    Friend 1 starts at the first column and Friend 2 starts
    at the last column of the first row.

    Time:  O(rows * cols² * 9)
           = O(rows * cols²)

    Space: O(rows * cols²)

    Note:
    This approach uses a separate 3D DP array and does not
    modify the original grid.
*/

public class NinjaAndHisFriends {

    public int maxChocolates(int[][] g) {

        int rows = g.length, cols = g[0].length;

        // dp[row][col1][col2] stores the maximum chocolates
        // collectible from this row to the last row when
        // Friend 1 is at col1 and Friend 2 is at col2.
        int[][][] dp = new int[rows][cols][cols];

        // Each friend can move left, stay in the same column,
        // or move right while going down to the next row.
        int[] moves = {-1, 0, 1};

        // Base case: initialize the last row.
        // No further moves are possible from the last row.
        for (int col1 = 0; col1 < cols; col1++) {
            for (int col2 = 0; col2 < cols; col2++) {

                // If both friends occupy the same cell,
                // count its chocolates only once.
                if (col1 == col2) {
                    dp[rows - 1][col1][col2] = g[rows - 1][col1];
                }

                // If they occupy different cells,
                // count chocolates from both cells.
                else {
                    dp[rows - 1][col1][col2] =
                        g[rows - 1][col1] + g[rows - 1][col2];
                }
            }
        }

        // Build the DP table from the second-last row
        // up to the first row.
        for (int row = rows - 2; row >= 0; row--) {

            for (int col1 = 0; col1 < cols; col1++) {
                for (int col2 = 0; col2 < cols; col2++) {

                    // Calculate the chocolates collected
                    // by both friends in the current row.
                    int currReward = g[row][col1];

                    // Count the second cell only if the
                    // friends are standing in different cells.
                    if (col1 != col2) {
                        currReward += g[row][col2];
                    }

                    // Store the maximum chocolates obtainable
                    // from all valid combinations of next moves.
                    int bestFuture = Integer.MIN_VALUE;

                    // Try all possible moves for Friend 1.
                    for (int move1 : moves) {

                        int nextCol1 = col1 + move1;

                        // Skip moves that go outside the grid.
                        if (nextCol1 < 0 || nextCol1 >= cols) {
                            continue;
                        }

                        // Try all possible moves for Friend 2.
                        for (int move2 : moves) {

                            int nextCol2 = col2 + move2;

                            // Skip moves that go outside the grid.
                            if (nextCol2 < 0 || nextCol2 >= cols) {
                                continue;
                            }

                            // Choose the best future state
                            // among all valid move combinations.
                            bestFuture = Math.max(
                                dp[row + 1][nextCol1][nextCol2],
                                bestFuture
                            );
                        }
                    }

                    // Total reward = current chocolates
                    // + maximum chocolates from the next row.
                    dp[row][col1][col2] = currReward + bestFuture;
                }
            }
        }

        // Friend 1 starts at column 0 and Friend 2
        // starts at the last column of the first row.
        return dp[0][0][cols - 1];
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 3, 1, 2},
            {3, 4, 2, 2},
            {5, 6, 3, 5},
            {1, 2, 4, 1}
        };

        NinjaAndHisFriends solution = new NinjaAndHisFriends();

        System.out.println(
            "Maximum Chocolates: " + solution.maxChocolates(grid)
        );

        // Output: Maximum Chocolates: 27
    }
}