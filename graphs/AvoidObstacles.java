import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AvoidObstacles {
  static int[] parent, size;
  static int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
  static void union(int a, int b){ // join 2 sets
    a = find(a); // get parent of a
    b = find(b); // get parent of b
    if(a != b){ // if parent[a] != parent[b]  -->  attach smaller treeunder the larger one
      if(size[a] < size[b]){
        int t = a;
        a = b;
        b = t;
      }
      parent[b] = a;
      size[a] += size[b];
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    StringBuilder out = new StringBuilder();

    while(T-- > 0){
      String[] xy = br.readLine().split(" ");
      int X = Integer.parseInt(xy[0]), Y = Integer.parseInt(xy[1]);
      int N = Integer.parseInt(br.readLine().trim());
      int[][] coords = new int[N][3];

      for(int i = 0; i < N; i++){
        String[] p = br.readLine().split(" ");
        coords[i][0] = Integer.parseInt(p[0]); // x
        coords[i][1] = Integer.parseInt(p[1]); // y
        coords[i][2] = Integer.parseInt(p[2]); // c
      }

      int total = N+4, TOP = N, BOTTOM = N+1, LEFT = N+2, RIGHT = N+3;
      parent = new int[total];
      size = new int[total];

      for(int i = 0; i < total; i++){
        parent[i] = i;
        size[i] = 1;
      }

      for(int i = 0; i < N; i++){
        int cx = coords[i][0], cy = coords[i][1], cr = coords[i][2];
        if(cx - cr <= 0) union(i, LEFT);
        if(cx + cr >= X) union(i, RIGHT);
        if(cy + cr >= Y) union(i, TOP);
        if(cy - cr <= 0) union(i, BOTTOM);
      }

      for(int i = 0; i < N; i++){
        for(int j = i+1; j < N; j++){
          long dx = coords[i][0] - coords[j][0], dy = coords[i][1] - coords[j][1];
          long rSum = coords[i][2] + coords[j][2];
          if(dx*dx + dy*dy <= rSum*rSum) union(i, j);
        }
      }

      boolean blocked = 
        find(TOP) == find(LEFT) ||
        find(TOP) == find(RIGHT) ||
        find(TOP) == find(BOTTOM);

      out.append(blocked ? "NO\n" : "YES\n");
    }

    System.out.println(out);
  }
}
