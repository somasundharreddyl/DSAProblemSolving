class Solution {
    int groupA = 1;
    int groupB = 2;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                if (!bfs(graph, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = groupA;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : graph[node]) {
                if (visited[neighbor] == -1) {
                    // assign opposite group
                    visited[neighbor] = (visited[node] == groupA) ? groupB : groupA;
                    q.add(neighbor);
                } else if (visited[neighbor] == visited[node]) {
                    // same color → not bipartite
                    return false;
                }
            }
        }

        return true;
    }
}