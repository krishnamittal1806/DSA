class Solution {
    public int largestRectangleArea(int[] arr) {

        int[] nse = findnse(arr);
        int[] pse = findpse(arr);
        int maxarea = 0;

        for( int i = 0; i < arr.length ; i++){
            maxarea = Math.max(maxarea , (arr[i] * (nse[i] - pse[i] - 1)));
        }

        return maxarea;
        
    }

    private int[] findnse(int[] arr){
        int n = arr.length;
        Stack<Integer> stack= new Stack<>();
        int[] ans = new int[n];

        for( int i = n-1 ; i >= 0 ; i--){

        while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
            stack.pop();
        }

        ans[i] = !stack.isEmpty() ? stack.peek() : n;

        stack.push(i);
        }

        return ans; 

    }
    private int[] findpse( int[] arr){
        int n = arr.length;
        Stack<Integer> stack= new Stack<>();
        int[] ans = new int[n];

        for( int i = 0 ; i < n ; i++){

        while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
            stack.pop();
        }

        ans[i] = !stack.isEmpty() ? stack.peek() : -1;

        stack.push(i);
        }

        return ans; 
    }

    
}