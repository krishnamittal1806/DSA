class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int maxarea = 0;
        for( int i = 0 ; i < n ; i++){
            while( !stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int element  = stack.peek();
                stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();

                maxarea = Math.max( maxarea , ( arr[element] * (nse - pse - 1)) );

            }
            stack.push(i);
        }
        while( !stack.isEmpty()){
            int nse = n;
            int element = stack.peek();
            stack.pop();

            int pse = stack.isEmpty() ? -1 : stack.peek();

            maxarea = Math.max( maxarea , ( arr[element] * (nse - pse - 1)) );
        }
     return maxarea;
    }
}