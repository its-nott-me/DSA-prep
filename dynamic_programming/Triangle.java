/*
    Problem: Triangle

    Description:
    Given a triangle, return the minimum path sum from top to bottom.

    At each step, we can move to:
        - The element directly below
        - The element diagonally below to the right

    Example:
        triangle = [
             [2],
            [3, 4],
           [6, 5, 7],
          [4, 1, 8, 3]
        ]

    Minimum path:
        2 -> 3 -> 5 -> 1

    Sum:
        2 + 3 + 5 + 1 = 11


    Approach: Bottom-Up Dynamic Programming

    Time Complexity:
    O(rows^2)

    Space Complexity:
    O(rows)

    Key Idea:
    - Start from the bottom row.
    - dp[col] stores the minimum path sum from
      the current position to the bottom.
    - For every element, choose the minimum of
      the two positions below it.

        dp[col] =
            triangle[row][col]
            + min(dp[col], dp[col + 1])

    - Process the triangle from bottom to top.
    - At the end, dp[0] contains the minimum path sum.
*/

import java.util.*;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {

        int rows = triangle.size();

        int[] dp = new int[rows];

        // Initialize with the bottom row
        for (int col = 0; col < rows; col++) {
            dp[col] = triangle.get(rows - 1).get(col);
        }

        // Process from bottom to top
        for (int row = rows - 2; row >= 0; row--) {

            for (int col = 0; col <= row; col++) {

                dp[col] =
                    triangle.get(row).get(col)
                    + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );

        System.out.println(
            "Minimum Total : "
            + minimumTotal(triangle)
        );
        // 2 + 3 + 5 + 1 = 11
    }
}
