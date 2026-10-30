class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
       // modified dijkistra algo lagani hai

       // prepare the adjacency list , including count

       List<List<List<Integer>>> adj = new ArrayList<>();
       for( int i = 0; i < n ; i++){
        adj.add(new ArrayList<>());
       }

       for( int[] edge : edges){
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];

        adj.get(u).add(Arrays.asList(v , wt));
       }

       int[][] result = new int[n][k+1];

       for( int[] row : result){
        Arrays.fill(row , Integer.MAX_VALUE);
       }
       
       PriorityQueue<int[]> pq = new PriorityQueue<>((a , b)-> Integer.compare(a[0],b[0]));

       result[0][1] = 0;
       pq.offer( new int[]{0,0,1});

       while( !pq.isEmpty()){
        int[] top = pq.poll();
        int d  = top[0];
        int node = top[1];
        int count = top[2];

        if( d > result[node][count]) continue;

        if( node == n-1) return d;

        for( List<Integer> it : adj.get(node)){
            int adjnode = it.get(0);
            int wt = it.get(1);

            int newcount = (labels.charAt(adjnode) == labels.charAt(node))? count + 1 : 1;

            if( newcount > k) continue;

            if( d + wt < result[adjnode][newcount]) {
                result[adjnode][newcount] = d+wt;
                pq.offer( new int[]{ d+wt , adjnode , newcount});
            }
        }
       }
       return -1;
    }
}