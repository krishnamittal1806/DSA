class Solution {
    int MOD = 1000000007;
    int n; int m ; int left = 0; ; int up = 1;

    // memoization = [i][j] ={-1,-1}

    private int solve( int[][] grid , int i , int j ,  int camefrom , int[][][] t){

        if( i >= n || j >= m) return 0 ;
        if( i == n-1 && j == m-1) return 1;

        if(t[i][j][camefrom] != -1) return t[i][j][camefrom];

        if( grid[i][j] == 1){
            if(camefrom == left){
                return t[i][j][camefrom] = solve(grid , i+1 , j , up , t);
            }
            else return t[i][j][camefrom] = solve(grid , i , j + 1 , left ,t);
        }
 
        int totalPathCount = 0;
        totalPathCount = (totalPathCount + solve(grid , i+1 , j , up , t)) % MOD;
        totalPathCount = (totalPathCount + solve(grid , i , j+1 , left , t)) % MOD;

        return t[i][j][camefrom] = totalPathCount;
    }
    public int uniquePaths(int[][] grid) {
        n = grid.length ;
        m = grid[0].length;

        int[][][] t = new int[n][m][2]; // memoiazation vector
        
        // initialization of memoization vector
        for( int i = 0; i < n ; i++){
            for( int j = 0; j < m ; j++){
                t[i][j][0] = -1;
                t[i][j][1] =-1;
            }
        }

        return solve( grid , 0 , 0 , left , t);
        
    }
}