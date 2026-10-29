class TreeAncestor {
    private int rows;
    private int cols;
    int[][] ancestor;

    public TreeAncestor(int n, int[] parent) {
        rows = n ;
        cols = (int) (Math.log(n) / Math.log(2)) + 1;
        ancestor = new int[rows][cols];


        for( int[]row : ancestor){
            Arrays.fill( row, -1);
        }

        // fill the 0th col first
        for( int node  = 0 ; node < n ; node++){
            ancestor[node][0] = parent[node];
        }

        for( int j=1 ; j < cols ; j++){
            for( int node = 0; node < n ; node++ ){
                if(ancestor[node][j-1] != -1){
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {

        for( int j = 0; j < cols ; j++){
            if( (k & (1 << j)) != 0){ // jth bit is set so we can take 2^j th jump
                node = ancestor[node][j];

                if( node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */