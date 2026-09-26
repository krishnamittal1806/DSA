class Node{
    int first;
    int second;
    int third;
    public Node(int first , int second , int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Node> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        for( int i = 0 ; i < n ; i++){ // marked all the zeros present initially
            for( int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add( new Node(i , j , 0));
                    vis[i][j] = 1;
                }
                else vis[i][j] = 0;
            }
        }
        int[] dx = { 1 , -1 , 0 , 0};
        int[] dy = {0 , 0 , 1 , -1};

        while( !q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[r][c] = steps;

            for( int i = 0 ; i < 4 ; i++){
                int nr = r +dx[i];
                int nc = c + dy[i];

                if( nr >= 0 && nc >= 0 && nr < n && nc < m && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.add( new Node(nr , nc , steps + 1)); 
                }
            }

        }
        return dist;
    }
}