/*
    Problem: Minimum Falling Path Sum

    Goal:
    Start from any cell in the first row and reach
    any cell in the last row with minimum total sum.

    Allowed moves:
    - Down       (r+1, c)
    - Down-Left  (r+1, c-1)
    - Down-Right (r+1, c+1)

    DP meaning:
    dp[r][c] =  minimum path sum to reach cell (r, c) from the first row.

    Idea:
    To reach (r, c), the previous cell can only be:
    - (r-1, c)
    - (r-1, c-1)
    - (r-1, c+1)

    Take the minimum of these valid parents and
    add the current cell value.

    Initialization:
    First row:
    dp[0][c] = matrix[0][c]

    Transition:
    dp[r][c] =  matrix[r][c] +
                min(
                    dp[r-1][c],
                    dp[r-1][c-1],
                    dp[r-1][c+1]
                )

    Answer:
    Minimum value in the last row of dp.

    Time: O(m * n)
    Space: O(m * n)
*/

public class MinimumFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {

                int minParent = dp[r - 1][c];

                if (c != 0)
                    minParent = Math.min(minParent, dp[r - 1][c - 1]);

                if (c != n - 1)
                    minParent = Math.min(minParent, dp[r - 1][c + 1]);

                dp[r][c] = minParent + matrix[r][c];
            }
        }

        int res = dp[m - 1][0];

        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println(
            "Minimum Falling Path Sum: " + minFallingPathSum(matrix)
        ); // Output: 13
    }
}