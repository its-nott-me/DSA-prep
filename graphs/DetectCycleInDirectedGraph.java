import java.util.*;

public class DetectCycleInDirectedGraph {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        int[] indegrees = new int[N];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            for(int neigh : adj.get(i)){
                indegrees[neigh]++;
            }
        }

        for(int i = 0; i < N; i++){
            if(indegrees[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int neigh : adj.get(node)){
                if(--indegrees[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        return count != N;
    }
}
