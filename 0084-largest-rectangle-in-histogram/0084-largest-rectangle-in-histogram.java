class Solution {
    public int largestRectangleArea(int[] arr) {
        int maxarea = 0;
        int n = arr.length ;
        int[] nse = findnse(arr);
        int[] pse = findpse(arr);

        for( int i = 0; i < n ; i++){
            int area = (nse[i] - pse[i] - 1) * arr[i];

            maxarea = Math.max(maxarea , area );
        }

        return maxarea;
    }
    private int[] findnse(int [] arr){
        int n = arr.length ;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for( int i = n -1 ; i >= 0 ; i--){
            while( !stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : n;

            stack.push(i);
        } 

        return ans;
    }
     private int[] findpse(int [] arr){
        int n = arr.length ;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for( int i = 0 ; i < n ; i++){
            while( !stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        } 

        return ans;
    }
}