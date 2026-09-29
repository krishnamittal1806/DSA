class Solution {
    private boolean bfs(int src, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int neighbor : graph[node]) {
                if(color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }
                else if(color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {

        int V = graph.length;

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(!bfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}