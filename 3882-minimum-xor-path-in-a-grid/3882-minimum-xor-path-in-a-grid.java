class Solution {
    public int minCost(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;

       BitSet[][] dp = new BitSet[n][m];

       for( int i = 0; i < n ; i++){
        for( int j = 0; j < m ; j++){
            dp[i][j] = new BitSet(1024);
        }
       }

       dp[0][0].set(grid[0][0]);

       for( int i = 0 ; i < n ; i++){
        for( int j = 0 ; j < m ; j++){
           if( i == 0 && j== 0) continue;

           BitSet combined = new BitSet(1024);

           if( i >  0){
            combined.or(dp[i-1][j]);
           }

           if( j > 0){
            combined.or(dp[i][j-1]);
           }

           for( int val = combined.nextSetBit(0) ; val >= 0 ; val = combined.nextSetBit( val + 1)){
            int result = val ^ grid[i][j];
            dp[i][j].set(result);
           }
        }
    }

    return dp[n-1][m-1].nextSetBit(0);
    }
}