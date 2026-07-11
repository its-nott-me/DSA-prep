/*
    Problem: Single Source Shortest Path using Dijkstra's Algorithm

    Description:
    Given a weighted graph with V vertices and a list of weighted edges,
    find the shortest distance from a given source vertex S
    to every other vertex.

    The graph in this implementation is treated as undirected,
    since each edge is added in both directions.

    Approach: Dijkstra's Algorithm (Priority Queue / Min Heap)

    Time Complexity: O((V + E) log V)
    - V = number of vertices
    - E = number of edges
    - Building the adjacency list takes O(E).
    - Each edge is relaxed at most once for every distance update.
    - Every insertion and removal from the priority queue
      takes O(log V).

    Space Complexity: O(V + E)
    - O(V + E) for the adjacency list.
    - O(V) for the distance array.
    - O(V) in the worst case for the priority queue.

    Key Idea:
    - Maintain the shortest known distance from the source
      to every vertex.
    - Always process the vertex with the minimum tentative
      distance using a min heap (priority queue).
    - Relax all outgoing edges of the current vertex.
    - If a shorter path to a neighbour is found,
      update its distance and push it into the priority queue.

    Notes:
    - Works only when all edge weights are non-negative.
    - The implementation uses a priority queue without
      a decrease-key operation.
    - Multiple entries for the same vertex may exist in
      the priority queue. Outdated (stale) entries are skipped
      using the condition:
          if (currentDistance > dist[node]) continue;
    - Unreachable vertices remain at Integer.MAX_VALUE.
*/

import java.util.*;

class Dijkstra {
    public static int[] dijkstra(int V, List<List<Integer>> edges, int S) {
        List<int[]>[] adj = new ArrayList[V];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[V];

        for(int i = 0; i < V; i++){
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(List<Integer> e : edges){
            adj[e.get(0)].add(new int[]{e.get(1), e.get(2)});
            adj[e.get(1)].add(new int[]{e.get(0), e.get(2)});
        }

        dist[S] = 0;
        pq.offer(new int[]{S, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int node = curr[0];
            int d = curr[1];

            if(d > dist[node]) continue;

            for(int[] next : adj[node]){
                int neighbour = next[0];
                int weight = next[1];

                if(dist[node] + weight < dist[neighbour]){
                  dist[neighbour] = dist[node] + weight;
                  pq.offer(new int[]{neighbour, dist[neighbour]});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(
          List.of(0, 1, 1),
          List.of(0, 2, 6),
          List.of(1, 2, 3)
        );

        int V = 3, S = 2;

        int[] dist = dijkstra(V, edges, S);

        System.out.println(Arrays.toString(dist));
    }
}
