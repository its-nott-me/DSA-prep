/*
    Problem: Shortest Path in a Directed Acyclic Graph (DAG)

    Description:
    Given a Directed Acyclic Graph (DAG) with N vertices
    (numbered from 0 to N-1) and M weighted directed edges,
    find the shortest distance from the source vertex 0
    to every other vertex.

    If a vertex is unreachable from the source,
    its distance is reported as -1.

    Approach: Topological Sort + Edge Relaxation

    Time Complexity: O(N + M)
    - N = number of vertices
    - M = number of edges
    - Building the adjacency list takes O(M).
    - Kahn's topological sort processes every vertex and edge once.
    - Each edge is relaxed exactly once.

    Space Complexity: O(N + M)
    - O(N + M) for the adjacency list.
    - O(N) for the indegree array.
    - O(N) for the distance array.
    - O(N) for the queue.

    Key Idea:
    - A DAG has a valid topological ordering.
    - Processing vertices in topological order guarantees that all
      incoming edges of a vertex have already been considered.
    - Relax every outgoing edge while traversing the topological order.
    - Since there are no cycles, each edge needs to be processed only once.

    Notes:
    - Works only for Directed Acyclic Graphs (DAGs).
    - Handles negative edge weights correctly because cycles do not exist.
    - Unreachable vertices remain at distance -1.
    - The source vertex is assumed to be 0.
*/

import java.util.*;

class ShortestPathInDAG {
    record Edge(int to, int weight){};

    public static int[] shortestPath(int N, int M, int[][] edges) {
        int[] dist = new int[N];
        List<Edge>[] adj = new ArrayList[N];
        int[] in = new int[N];

        for(int i = 0; i < N; i++){
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int[] e : edges){
            adj[e[0]].add(new Edge(e[1], e[2]));
            in[e[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++)
            if(in[i] == 0)
                q.offer(i);

        dist[0] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(dist[curr] != Integer.MAX_VALUE)
                for(Edge e : adj[curr])
                    if (dist[curr] + e.weight() < dist[e.to()]) {
                        dist[e.to()] = dist[curr] + e.weight();
                    }

            for(Edge e : adj[curr]){
                if(--in[e.to()] == 0){
                    q.offer(e.to());
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    public static void main(String[] args) {

        int[][] edges = {
                {0, 1, 2},
                {0, 2, 1},
                {0, 3, 4},
                {2, 3, 3},
                {1, 4, 7},
                {3, 4, 1}
        };

        System.out.println(Arrays.toString(shortestPath(5, edges.length, edges)));
        // Output: [0, 2, 1, 4, 5]
    }
}