/*
    Problem: Number of Provinces (Find Circle Number)

    Description:
    Given an adjacency matrix isConnected where isConnected[i][j] = 1 means
    city i is directly connected to city j, find the number of connected
    components (provinces) in the graph.

    Approach: Depth First Search (DFS)

    Time Complexity: O(n^2)
    Space Complexity: O(n) (visited array + recursion stack)

    Key Idea:
    - Treat the adjacency matrix as an undirected graph
    - Each unvisited node starts a new DFS traversal
    - DFS marks all nodes in the same connected component
    - The number of DFS calls equals the number of provinces

    Notes:
    - Use visited array to avoid revisiting nodes
    - Matrix traversal checks all possible connections
*/

class NumberOfProvinces {
    public void dfs(int n, int[][] adjMatrix, boolean[] visited){
        if(visited[n]) return;
        visited[n] = true;

        for(int i = 0; i < adjMatrix.length; i++){
            if(adjMatrix[n][i] == 1 && !visited[i]){
                dfs(i, adjMatrix, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];

        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                count++;
                dfs(i, isConnected, visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfProvinces sol = new NumberOfProvinces();

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int result = sol.findCircleNum(isConnected);
        System.out.println(result); // Output: 2
    }
}