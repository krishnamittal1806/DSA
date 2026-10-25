class Pair{
    int first;
    int second;

    public Pair(int first , int second){
        this.first = first ;
        this.second = second;
    }
}

class Solution {
    private void bfs( int row , int col , int[][] vis , int[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row , col));

        int[] dx = {1,-1,0,0};
        int[] dy = { 0, 0 , 1 , -1};

        while(! q.isEmpty()){
            int x = q.peek().first;
            int y = q.peek().second;
            q.remove();

            for( int d = 0; d < 4 ; d++){
                int nrow = dx[d] + x;
                int ncol = dy[d] + y;

                if( nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0){
                    bfs(nrow , ncol , vis , grid);
                }
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int count = 0;

        //Marked all the connected 0s of the boundary
        for( int r = 0 ; r < n ; r++){
            if(grid[r][0] == 0 && vis[r][0] == 0){
                bfs(r , 0 , vis , grid);
            }
             if(grid[r][m-1] == 0 && vis[r][m-1] == 0){
                bfs(r , m-1 , vis , grid);
            }
        }

        for( int c = 0 ; c < m ; c++){
            if(grid[0][c] == 0 && vis[0][c] == 0){
                bfs(0 , c , vis , grid);
            }
            if(grid[n-1][c] == 0 && vis[n-1][c] == 0){
                bfs(n-1 , c , vis , grid);
            }
        }

        // now Traverse the entire grid and the 0s that are not marked visited will form the closed islands.
        
        for( int r = 0; r < n ; r++){
            for( int c = 0; c < m ; c++){
                if(grid[r][c] == 0 && vis[r][c] == 0){
                    count++;
                    bfs(r , c , vis , grid);
                }
            }
        }
        return count;
    }
}