import java.util.*;

/*
  Problem: Network Delay Time

  Description:
  You are given a network of n nodes labeled from 1 to n.
  Each directed edge is represented as:
      [source, destination, travelTime]

  A signal is sent from a starting node k.

  Return the minimum time required for all nodes to receive
  the signal.

  If it is impossible for every node to receive the signal,
  return -1.

  Approach: Dijkstra's Algorithm (Min Heap)

  Time Complexity: O((V + E) log V)
  - V = number of nodes
  - E = number of directed edges
  - Each node/edge is processed using a priority queue.

  Space Complexity: O(V + E)
  - O(E) for the adjacency list.
  - O(V) for the distance array.
  - O(V) for the priority queue in the worst case.

  Key Idea:
  - Build an adjacency list from the given edges.
  - Store the shortest known time to each node.
  - Use a Min Heap (Priority Queue) to always process
    the node with the smallest current delay.
  - Relax all outgoing edges of the current node.
  - Ignore outdated entries in the priority queue.
  - After processing, the answer is the maximum distance
    among all nodes because every node must receive the
    signal.

  Notes:
  - Dijkstra's algorithm works because all edge weights
    (travel times) are non-negative.
  - If any node remains unreachable, return -1.
*/

public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // {node, currentTime}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int time = curr[1];

            // Ignore outdated entries
            if (time > dist[node]) {
                continue;
            }

            for (int[] next : graph[node]) {

                int nextNode = next[0];
                int weight = next[1];

                if (dist[nextNode] > time + weight) {

                    dist[nextNode] = time + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int maxDelay = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }

    public static void main(String[] args) {

        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };

        int n = 4;
        int k = 2;

        int result = networkDelayTime(times, n, k);

        System.out.println("Network Delay Time: " + result);
    }
}

// public class NetworkDelayTime {

//     public static int networkDelayTime(int[][] times, int n, int k) {

//         int[] delay = new int[n + 1];
//         Arrays.fill(delay, Integer.MAX_VALUE);

//         delay[k] = 0;

//         for (int i = 0; i < n; i++) {

//             int[] temp = Arrays.copyOf(delay, n + 1);

//             for (int[] conn : times) {

//                 int u = conn[0];
//                 int v = conn[1];
//                 int w = conn[2];

//                 if (delay[u] != Integer.MAX_VALUE &&
//                     temp[v] > delay[u] + w) {

//                     temp[v] = delay[u] + w;
//                 }
//             }

//             delay = temp;
//         }

//         int maxDelay = 0;

//         for (int i = 1; i <= n; i++) {
//             maxDelay = Math.max(maxDelay, delay[i]);
//         }

//         return maxDelay == Integer.MAX_VALUE ? -1 : maxDelay;
//     }

//     public static void main(String[] args) {

//         int[][] times = {
//             {2, 1, 1},
//             {2, 3, 1},
//             {3, 4, 1}
//         };

//         int n = 4;
//         int k = 2;

//         int result = networkDelayTime(times, n, k);

//         System.out.println("Network Delay Time: " + result);
//     }
// }