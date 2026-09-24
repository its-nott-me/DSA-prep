import java.util.*;

/*
  Problem: Path With Minimum Effort

  Description:
  You are given a 2D grid where heights[row][col] represents
  the height of each cell.

  Start from the top-left cell (0,0) and reach the
  bottom-right cell (rows-1, cols-1).

  You can move in 4 directions:
  - Up
  - Down
  - Left
  - Right

  The effort of a path is defined as the maximum absolute
  difference in heights between two consecutive cells
  along that path.

  Return the minimum effort required to travel from the
  source to the destination.

  Approach: Dijkstra's Algorithm (Min Heap)

  Time Complexity: O((R * C) * log(R * C))
  - R = number of rows
  - C = number of columns
  - Every cell may be inserted into the priority queue.
  - Each insertion/removal from the priority queue takes
    O(log(R * C)) time.

  Space Complexity: O(R * C)
  - O(R * C) for the distance array.
  - O(R * C) for the priority queue in the worst case.

  Key Idea:
  - Instead of minimizing the total cost, minimize the
    maximum edge cost encountered so far.
  - Use Dijkstra's algorithm where:
      * Node = grid cell
      * Cost = minimum possible effort to reach that cell
  - The effort to move to a neighbor is:
      max(currentEffort, heightDifference)
  - Always process the cell with the smallest effort first.
  - The first time the destination is removed from the
    priority queue, its effort is the minimum possible.

  Notes:
  - The distance array stores the minimum effort required
    to reach each cell.
  - A priority queue is used as a Min Heap based on effort.
  - Unlike normal shortest path problems, the path cost is
    the maximum edge weight instead of the sum of weights.
*/

public class PathWithMinimumEffort {

    public static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 &&
               row < rows &&
               col >= 0 &&
               col < cols;
    }

    public static int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {
            {0, -1}, {0, 1},
            {-1, 0}, {1, 0}
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int effort = curr[2];

            if (r == rows - 1 && c == cols - 1) {
                return effort;
            }

            if (effort > dist[r][c]) {
                continue;
            }

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (isValid(nr, nc, rows, cols)) {

                    int newEffort = Math.max(
                            effort,
                            Math.abs(heights[r][c] - heights[nr][nc])
                    );

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[][] heights = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };

        int result = minimumEffortPath(heights);

        System.out.println("Minimum Effort Required: " + result);
    }
}