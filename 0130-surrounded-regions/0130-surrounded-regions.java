class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean [][] vis = new boolean[n][m];

        for( int i = 0 ; i < m ; i++){
            if( board[0][i] == 'O' && !vis[0][i]){
                dfs(0 , i , board , vis);
            }
        }

        for( int i = 1 ; i < n - 1 ; i++){
            if(board[i][m-1] == 'O' && !vis[i][m-1]){
                dfs( i , m-1 , board , vis);
            }
        }

        for( int i = m-1 ; i>= 0 ; i--){
            if( board[n-1][i] == 'O' && !vis[n-1][i]){
                dfs( n-1 , i , board , vis);
            }
        }

        for( int i = n - 2 ; i >= 0 ; i--){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs( i , 0 , board , vis);
            }
        }

        for( int i = 0; i < n ; i++){
            for( int j = 0; j < m ; j++){
                if( !vis[i][j] && board[i][j] == 'O'){
                    board[i][j] ='X';
                }
            }
        }
    }

    private void dfs( int row , int col , char[][] board , boolean[][] vis ){
        int n = board.length;
        int m = board[0].length;

        if( row < 0 || row >= n || col < 0 || col >= m || board[row][col] == 'X'|| vis[row][col]){
            return;
        }

        vis[row][col] = true;

        dfs( row+1 , col , board , vis);
        dfs(row-1 , col , board, vis);
        dfs(row , col+1 , board , vis);
        dfs(row , col-1 , board , vis);
    }
}