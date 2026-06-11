import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class AvoidCities{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] parts = br.readLine().split(" ");
    int n = Integer.parseInt(parts[0]), m = Integer.parseInt(parts[1]);
    parts = br.readLine().split(" ");
    int s = Integer.parseInt(parts[0]), t = Integer.parseInt(parts[1]);
    parts = br.readLine().split(" ");
    int[] cursed = new int[n];
    
    for(int i = 0; i < n; i++) cursed[i] = Integer.parseInt(parts[i]);

    if(cursed[s] == 1 || cursed[t] == 1) System.out.println(-1);

    List<Integer>[] adj = new List[n];
    for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    for(int i = 0; i < m; i++) {
      parts = br.readLine().split(" ");
      int u = Integer.parseInt(parts[0]), v = Integer.parseInt(parts[1]);
      if(cursed[u] == 0){
        adj[u].add(v);
        adj[v].add(u);
      }
    }

    int[] dist = new int[n];
    Arrays.fill(dist, -1);
    Queue<Integer> q = new ArrayDeque<>();
    dist[s] = 0;
    q.add(s);
    while(!q.isEmpty()){
      int node = q.poll();
      for(int neighbor : adj[node]){
        if(dist[neighbor] == -1){
          dist[neighbor] = dist[node]+1;
          q.add(neighbor);
        }
      }
    }

    System.out.println(dist[t]);
  }

  // Input 
// 5 5
// 0 2
// 0 1 0 0 0
// 0 1
// 1 2
// 0 3
// 3 4
// 4 2

  // Ouput: 3
}