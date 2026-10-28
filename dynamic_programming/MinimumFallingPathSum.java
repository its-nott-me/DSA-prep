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
    matrix[r][c] = minimum path sum to reach cell (r, c)
                   from any cell in the first row.

    Idea:
    To reach (r, c), the previous cell can only be:
    - (r-1, c)
    - (r-1, c-1)
    - (r-1, c+1)

    We find the minimum valid parent and add it
    directly to matrix[r][c].

    Transition:

    matrix[r][c] += min(
        matrix[r-1][c],
        matrix[r-1][c-1],
        matrix[r-1][c+1]
    );

    Since we modify the input matrix directly,
    we don't need a separate DP array.

    Answer:
    Minimum value in the last row.

    Time:  O(n²)
    Space: O(1) extra space

    Note:
    This approach modifies the original matrix.
*/

public class MinimumFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        // Build the minimum path sum for every cell
        for (int row = 1; row < n; row++) {

            for (int col = 0; col < n; col++) {

                // Start with the cell directly above
                int parent = matrix[row - 1][col];

                // Check upper-left
                if (col > 0) {
                    parent = Math.min(
                        parent,
                        matrix[row - 1][col - 1]
                    );
                }

                // Check upper-right
                if (col < n - 1) {
                    parent = Math.min(
                        parent,
                        matrix[row - 1][col + 1]
                    );
                }

                // Add the minimum parent path
                // to the current cell
                matrix[row][col] += parent;
            }
        }

        // Find the minimum path sum in the last row
        int result = matrix[n - 1][0];

        for (int col = 1; col < n; col++) {
            result = Math.min(result, matrix[n - 1][col]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println(
            "Minimum Falling Path Sum: "
            + minFallingPathSum(matrix)
        );

        // Output: 13
    }
}
