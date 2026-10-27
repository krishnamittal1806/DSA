class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        for( int i = 0 ; i < m ; i++){
            Arrays.fill(grid[i] , '#');
        }

        int r = 0 ;int c = 0;
        grid[0][0] ='.';

        while( r < m -1 || c < n - 1){
            if( c < n -1){
                c++;
                grid[r][c]='.';
            }
            if( r < m-1){
                r++;
                grid[r][c] = '.';
            }
        }

        String[] ans = new String[m];

        for( int i = 0 ; i < m ; i++){
            ans[i] = new String(grid[i]);
        }

        return ans;


    }
}