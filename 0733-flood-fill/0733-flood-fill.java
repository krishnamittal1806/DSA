class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int original = image[sr][sc];
        int[][] vis = new int[n][m];

        dfs( sr , sc , vis , image , color , original);

        return image ;
    }
    private void dfs( int sr , int sc , int[][] vis , int[][] image , int color , int original){
        int n = image.length ;
        int m = image[0].length;

        if( sr < 0 || sr > n-1 || sc < 0 || sc > m-1 || image[sr][sc] != original || vis[sr][sc] == 1){
            return;
        }
        vis[sr][sc] = 1;
        image[sr][sc] = color;
        dfs(sr+1 , sc , vis , image , color , original);
        dfs(sr-1 , sc , vis , image , color,original);
        dfs( sr , sc+1 , vis , image , color,original);
        dfs( sr , sc-1 , vis , image , color,original);
    }
}