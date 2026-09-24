import java.util.*;

/*
  Problem: Cheapest Flights Within K Stops

  Description:
  There are n cities connected by directed flights.
  Each flight is represented as:
      [source, destination, price]

  Given:
  - Number of cities (n)
  - List of flights
  - Source city (src)
  - Destination city (dst)
  - Maximum allowed stops (k)

  Find the cheapest price from the source to the destination
  using at most k stops.

  If no such route exists, return -1.

  Approach: Bellman-Ford Algorithm

  Time Complexity: O((K + 1) * E)
  - K = maximum allowed stops
  - E = number of flights
  - In each iteration, every flight is relaxed once.

  Space Complexity: O(N)
  - O(N) for the distance array.
  - O(N) for the temporary array.

  Key Idea:
  - A path with at most K stops can contain at most
    K + 1 edges.
  - Perform exactly K + 1 relaxation rounds.
  - During each round, use a temporary array so that
    updates made in the current iteration are not used
    again in the same iteration.
  - This guarantees that each iteration only considers
    paths with one additional edge.

  Notes:
  - This is a modified Bellman-Ford algorithm.
  - Using a temporary array is essential to enforce
    the stop constraint.
  - If the destination remains unreachable after all
    iterations, return -1.
*/

public class CheapestFlightWithKStops {

    public static int findCheapestPrice(int n, int[][] flights,
                                        int src, int dst, int k) {

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[src] = 0;

        for (int i = 0; i <= k; i++) {

            int[] temp = Arrays.copyOf(cost, n);

            for (int[] flight : flights) {

                int u = flight[0];
                int v = flight[1];
                int w = flight[2];

                if (cost[u] != Integer.MAX_VALUE && temp[v] > cost[u] + w) {
                    temp[v] = cost[u] + w;
                }
            }

            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 3, 100},
            {0, 2, 500},
            {1, 3, 600}
        };

        int src = 0;
        int dst = 3;
        int k = 1;

        int result = findCheapestPrice(n, flights, src, dst, k);

        System.out.println("Cheapest Price: " + result);
    }
}