/*
    Problem: Shortest Path in an Unweighted Undirected Graph

    Description:
    Given an undirected graph with N vertices (numbered from 0 to N-1)
    and M edges, find the shortest distance from the source vertex 0
    to every other vertex.

    If a vertex is unreachable from the source, its distance is -1.

    Approach: Breadth-First Search (BFS)

    Time Complexity: O(N + M)
    - N = number of vertices
    - M = number of edges
    - Building the adjacency list takes O(M).
    - BFS visits each vertex and edge at most once.

    Space Complexity: O(N + M)
    - O(N + M) for the adjacency list.
    - O(N) for the distance array.
    - O(N) for the BFS queue in the worst case.

    Key Idea:
    - Since every edge has equal weight (1), BFS naturally explores
      vertices level by level.
    - The first time a vertex is reached, it is guaranteed to be via
      the shortest path from the source.
    - Use an adjacency list to efficiently represent the graph.
    - Store shortest distances directly in the result array.
      A value of -1 indicates the vertex has not been visited.

    Notes:
    - BFS is the optimal algorithm for shortest paths in an
      unweighted graph.
    - No separate visited array is required since a distance of -1
      already indicates an unvisited vertex.
    - This implementation assumes the source vertex is 0.
*/

import java.util.*;

public class ShortestPathInUnweightedUndirectedGraph {

    public static int[] shortestPath(int[][] edges, int N, int M) {
        int[] res = new int[N];
        Arrays.fill(res, -1);

        List<Integer>[] adj = new ArrayList[N];
        Arrays.setAll(adj, i -> new ArrayList<>());

        // Build the undirected graph
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        res[0] = 0;
        q.offer(0);

        // Standard BFS
        while (!q.isEmpty()) {
            int node = q.poll();
            int dist = res[node];

            for (int next : adj[node]) {
                if (res[next] == -1) {
                    res[next] = dist + 1;
                    q.offer(next);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        // Graph:
        //      0
        //     / \
        //    1   2
        //    |   |
        //    3---4
        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 4},
                {3, 4}
        };

        System.out.println(Arrays.toString(shortestPath(edges1, 5, edges1.length)));
        // [0, 1, 1, 2, 2]
    }
}