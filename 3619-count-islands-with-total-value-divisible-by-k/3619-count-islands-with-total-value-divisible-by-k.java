class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second  = second;
    }
}
class Solution {
    private long bfs( int row , int col , int[][] grid , int[][] vis){
        
        vis[row][col] = 1;
        long sum = 0;
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add( new Pair(row , col));
        int[] dx = {1 , -1 , 0 , 0};
        int[] dy = { 0 , 0 , 1 , -1};

        while(!q.isEmpty()){
            int x = q.peek().first;
            int y = q.peek().second;
            q.remove();
            sum += grid[x][y];

            for( int d = 0 ; d < 4 ; d++){
                int nrow = dx[d] + x;
                int ncol = dy[d] + y;

                if( nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] != 0 && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add( new Pair(nrow , ncol));
                }
            }
           
        }
        return sum;

    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis  = new int[n][m];
        int ans = 0; 

        for( int r = 0; r < n ; r++){
            for( int c = 0 ; c < m ; c++){
                if( grid[r][c] != 0 && vis[r][c] == 0){
                    
                    long sum = bfs( r , c , grid , vis );
                    if(sum % k == 0) ans++;
                }
            }
        }
        
        return ans;
    }
}