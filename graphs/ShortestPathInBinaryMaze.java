import java.util.*;

/*
  Problem: Shortest Path in Binary Matrix

  Description:
  Given an n x n binary matrix grid, find the length of the
  shortest clear path from the top-left cell (0,0) to the
  bottom-right cell (n-1,n-1).

  A clear path:
  - Can only visit cells containing 0.
  - Can move in 8 directions (horizontal, vertical, diagonal).
  - The length of the path is the number of cells visited.

  If no clear path exists, return -1.

  Approach: Breadth First Search (BFS)

  Time Complexity: O(N^2)
  - N = number of rows/columns in the square matrix.
  - Each cell is visited at most once.
  - For every cell, we check 8 possible directions,
    which is a constant operation.

  Space Complexity: O(N^2)
  - O(N^2) for the queue in the worst case.
  - The input grid itself is used as the visited array.

  Key Idea:
  - Since every move has the same cost (1), BFS guarantees
    the shortest path.
  - Process cells level by level.
  - The current BFS level represents the current path length.
  - Mark cells as visited when adding them to the queue to
    avoid duplicate processing.
  - The first time we reach the destination cell, the path
    length is the shortest possible.

  Notes:
  - The grid is modified by changing visited cells from 0 to 1.
  - The algorithm supports diagonal movement.
  - If the source or destination cell is blocked, return -1.
*/


public class ShortestPathInBinaryMaze {

  public static boolean isValid(int u, int v, int n) {
    return u >= 0 && u < n && v >= 0 && v < n;
  }


  public static int shortestPathBinaryMatrix(int[][] grid) {
    int dist = -1;
    int n = grid.length;

    if (n == 1) {
      return grid[0][0] == 0 ? 1 : -1;
    }

    Queue<int[]> q = new ArrayDeque<>();

    if (grid[0][0] == 0 && grid[n - 1][n - 1] == 0) {
      dist = 1;
      grid[0][0] = 1;
      q.offer(new int[]{0, 0});
    }

    int[][] neighbours = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1},           {0, 1},
      {1, -1},  {1, 0},  {1, 1}
    };

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        int[] curr = q.poll();

        for (int[] neigh : neighbours) {
          int u = curr[0] + neigh[0];
          int v = curr[1] + neigh[1];

          if (isValid(u, v, n) && grid[u][v] == 0) {
            grid[u][v] = 1;
            q.offer(new int[]{u, v});

            if (u == n - 1 && v == n - 1) {
              return ++dist;
            }
          }
        }
      }

      dist++;
    }

    return -1;
  }


  public static void main(String[] args) {
    int[][] grid = {
      {0, 0, 0, 0, 1},
      {1, 0, 0, 0, 0},
      {0, 1, 0, 1, 0},
      {0, 0, 0, 1, 1},
      {0, 0, 0, 1, 0}
    };

    int result = shortestPathBinaryMatrix(grid);

    System.out.println("Shortest Path Length: " + result);
  }
}