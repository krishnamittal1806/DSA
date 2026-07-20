class Solution {
    public int maximalRectangle(char[][] matrix) {
        if( matrix.length == 0) return 0;

        int n = matrix[0].length;
        int maxarea = 0;
        int[] arr = new int[n+1];

        for( char[] row : matrix){
            // calculate the largest rectange area int that row

            for( int i = 0 ; i < n ; i++){
                if(row[i] == '1') arr[i]++;
                else arr[i] = 0;
            }
            maxarea = Math.max(maxarea , largestHistogramArea(arr));
        }
        return maxarea;
    }

    private int largestHistogramArea(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;

        int maxarea = 0;
        for( int i = 0; i < n ; i++){
           
            while( !stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int element = stack.peek();
                stack.pop();
                int nse = i;

                int pse = !stack.isEmpty() ? stack.peek() : -1;

                maxarea = Math.max(maxarea , arr[element] * ( nse - pse -1));
            }
            stack.push(i);
        }

        while( !stack.isEmpty()){ // this loop is for those element that have no nse

                int nse = n;
                int element = stack.peek();
                stack.pop();

                int pse = !stack.isEmpty() ? stack.peek() : -1;

                maxarea = Math.max(maxarea , (arr[element] * ( nse - pse -1)));
        }          

        return maxarea;
    }
}