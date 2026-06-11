import java.util.*;

// BFS

// public class DetectCyclesInUndirectedGraph {
//     public boolean bfs(int start, List<Integer>[] adj, boolean[] visited){
//         int[] parent = new int[visited.length];

//         Arrays.fill(parent, -1);

//         Deque<Integer> q = new ArrayDeque<>();
//         q.offer(0);
//         visited[0] = true;

//         while(!q.isEmpty()){
//             int u = q.poll();
//             for(int v : adj[u]){
//                 if(!visited[v]){
//                     visited[v] = true;
//                     parent[v] = u;
//                     q.offer(v);
//                 } else if(parent[u] != v) {
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }

//     public boolean isCycle(int V, List<Integer>[] adj) {
//         boolean[] visited = new boolean[V];
        
//         for(int i = 0; i < V; i++){
//             if(!visited[i]){
//                 if(bfs(i, adj, visited)) return true;
//             }
//         }

//         return false;
//     }
// }




// DFS

class Solution {
    public boolean dfs(int i, List<Integer>[] adj, boolean[] visited, int parent){
        for(int neighbor : adj[i]){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                if(dfs(neighbor, adj, visited, i)) return true;
            }

            else if(parent != neighbor) {
                return true;
            }
        }

        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dfs(i, adj, visited, i)) return true;
            }
        }

        return false;
    }
}
