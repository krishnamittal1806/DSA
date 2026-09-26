class Node{
    int first ; int second ; int third;
    public Node(int first , int second , int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int[][] highestPeak(int[][] iswater) {
        int n = iswater.length;
        int m = iswater[0].length;

        Queue<Node> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        int[][] vis = new int[n][m];

        for( int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if( iswater[i][j] == 1){
                    vis[i][j] = 1 ;
                    q.add( new Node( i , j , 0));
                }
                else vis[i][j] = 0;
            }
        }

        int[] dx = { 1 , -1 , 0 , 0 }; int[] dy = { 0 , 0 , 1 ,-1};

        while( !q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second ;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;

            for( int d = 0 ; d < 4 ; d++){
                int nrow = row +dx[d]; int ncol = col + dy[d];

                if( nrow >=0  && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow , ncol , steps + 1));
                }
            }
        }
        return dist;
    }
}