import java.util.*;

public class TopoSort {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] res = new int[V];
        int[] indegrees = new int[V];

        for(int i = 0; i < V; i++){
            for(int a : adj.get(i)){
                indegrees[a]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < V; i++){
            if(indegrees[i] == 0){
                q.offer(i);
            }
        }

        int k = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int node = q.poll();
                res[k++] = node;

                for(int neighbor : adj.get(node)){
                    if(--indegrees[neighbor] == 0){
                        q.offer(neighbor);
                    }
                }
            }
        }

        return res;
    }
}