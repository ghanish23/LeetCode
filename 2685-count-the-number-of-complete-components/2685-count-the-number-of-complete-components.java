class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        visited = new boolean[n];
        int complete = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] res = dfs(i);
                int vertices = res[0];
                int degreeSum = res[1];
                int actualEdges = degreeSum / 2;
                int expectedEdges = vertices * (vertices - 1) / 2;
                if (actualEdges == expectedEdges)
                    complete++;
            }
        }
        return complete;
    }
    private int[] dfs(int node) {
        visited[node] = true;
        int vertices = 1;
        int degreeSum = graph[node].size();
        for (int nei : graph[node]) {
            if (!visited[nei]) {
                int[] temp = dfs(nei);
                vertices += temp[0];
                degreeSum += temp[1];
            }
        }
        return new int[]{vertices, degreeSum};
    }
}