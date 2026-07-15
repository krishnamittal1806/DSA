class Solution {
    private int largestHistogram(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int maxarea = 0;

        for( int i = 0 ; i < n ; i++){

        while( !stack.isEmpty() && arr[stack.peek()] > arr[i]){
            int element = stack.peek();
            int nse = i;
            stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();

            maxarea = Math.max( maxarea , (( nse - pse - 1 ) * arr[element] ));
        }
        stack.push(i);
        }

         while(!stack.isEmpty()){
            int nse = n;
            int element = stack.peek();
            stack.pop();
            int pse = stack.isEmpty()?-1:stack.peek();

            maxarea = Math.max( maxarea , (( nse - pse - 1 ) * arr[element] ));

            
        }

        return maxarea;
    }

       
    public int maximalRectangle(char[][] matrix) {
        if( matrix.length == 0) return  0;

        int m = matrix[0].length;
        int maxarea = 0;

        int[] arr = new int[m+1];

        for( char[] row : matrix){

            for( int i = 0 ; i < m ; i++){
                if(row[i] == '1') arr[i]++;
                else arr[i] = 0;
            }
            maxarea = Math.max(maxarea , largestHistogram(arr));
        }

        return maxarea;
        
    }

}