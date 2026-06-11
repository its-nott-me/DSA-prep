import java.util.*;

class Traversal {
    public static void dfs(int node, Map<Integer, List<Integer>> adjMap, Set<Integer> visited, List<Integer> result){
        if(visited.contains(node)) return;

        visited.add(node);
        result.add(node);

        for(int adj : adjMap.getOrDefault(node, new ArrayList<>())){
            dfs(adj, adjMap, visited, result);
        }
    }

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> adjMap = buildAdjMap(edges);
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < V; i++){
            if(!visited.contains(i)){
                dfs(i, adjMap, visited, result);
            }
        }

        return result;
    }

    public static Map<Integer, List<Integer>> buildAdjMap(List<List<Integer>> edges){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(List<Integer> edge : edges){
            map.putIfAbsent(edge.get(0), new ArrayList<>());
            map.putIfAbsent(edge.get(1), new ArrayList<>());

            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }

        return map;
    }
    
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> adjMap = buildAdjMap(edges);

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>(); 

        for(int i = 0; i < V; i++){
            if(!visited.contains(i)){
                q.offer(i);
                visited.add(i);
        
                while(!q.isEmpty()){
                    int node = q.poll();
                    result.add(node);
        
                    for(int adj : adjMap.getOrDefault(node, new ArrayList<>())){
                        if(!visited.contains(adj)){
                            visited.add(adj);
                            q.offer(adj);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Traversal t = new Traversal();

        int V = 6;

        // edges: undirected graph
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(4, 5)); // separate component

        List<Integer> dfsResult = t.dfsOfGraph(V, edges);
        List<Integer> bfsResult = t.bfsOfGraph(V, edges);

        System.out.println("DFS: " + dfsResult);
        System.out.println("BFS: " + bfsResult);
    }

}