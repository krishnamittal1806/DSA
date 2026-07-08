class Solution {
    public int[] dailyTemperatures(int[] arr) {
      Stack<int[]> stack = new Stack<>();

      int[] ans = new int[arr.length];

      stack.push(new int[] {arr[arr.length-1] , arr.length - 1});
      ans[arr.length - 1] = 0;

      for( int i = arr.length - 2 ; i >=0 ; i--){
        while( !stack.isEmpty()){
            int top = stack.peek()[0];

            if(top > arr[i]){
                ans[i] = stack.peek()[1] - i;
                break;
            }
            else {
                stack.pop();
            }
        }

        if(stack.isEmpty()){
                ans[i] = 0;
        }

        stack.push(new int[] {arr[i] , i});
      }

       return ans; 
    }
}