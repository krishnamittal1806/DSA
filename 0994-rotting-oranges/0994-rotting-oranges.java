class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minutes = 0;

        Queue<int[]> queue = new LinkedList<>();

        // first store all the Rotten oranges in Queue 

        for( int i = 0; i < m ; i++){
            for( int j = 0; j< n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i , j , 0});
                }
            }
        }
        int maxMinutes = 0;
        // mark adj nodes aas rotten and push it inot Queue till its not empty
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            int x = curr[0] ; int y = curr[1]; int time = curr[2];

            if(y > 0 && grid[x][y-1] == 1){
                grid[x][y-1] = 2;
                queue.add(new int[]{x,y-1,time+1}); 
            }
            if(y < n-1 && grid[x][y+1] == 1){
                grid[x][y+1] = 2;
                queue.add(new int[]{x,y+1,time+1}); 
            }
            if(x < m-1 && grid[x+1][y] == 1){
                grid[x+1][y] = 2;
                queue.add(new int[]{x+1,y,time+1}); 
            }
            if(x > 0  && grid[x-1][y] == 1){
                grid[x-1][y] = 2;
                queue.add(new int[]{x-1,y,time+1}); 
            }

            maxMinutes = Math.max(time , maxMinutes);
            
        }

        //finally traverse the entire grid if any fresh orange is found return -1;
        for( int i = 0; i < m ; i++){
            for( int j = 0; j< n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return maxMinutes;

    }
}