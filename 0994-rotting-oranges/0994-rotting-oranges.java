class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0 ;
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int total = 0 ; int count = 0; int time = 0;

        // count the total no. of oranges at t = 0 and 
        // add all the rotten oranges present at t = 0 into q
        for( int i = 0 ;i < n ; i++){
            for( int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0) total++;

                if( grid[i][j] == 2){
                    q.add(new int[]{i , j});
                }
            }
        }
        int[] dx = {1 , -1 , 0 , 0 };
        int[] dy = {0 , 0 , 1 , -1};

        while( !q.isEmpty()){
            int k = q.size();
            count += k ;

            for( int i = 0 ; i < k ; i++){ 
                int[] pos = q.poll();

                int x = pos[0] ; int y = pos[1];
                for( int d = 0 ; d < 4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if( nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != 1){
                       continue;
                    }      
                      
                    grid[nx][ny] = 2;
                    q.add(new int[]{nx , ny}) ;
                }
            }
            if( !q.isEmpty()) time++;
        }

        return count == total ? time : -1;
    }
}