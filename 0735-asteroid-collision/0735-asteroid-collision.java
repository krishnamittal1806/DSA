class Solution {
    public int[] asteroidCollision(int[] arr) {
       
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        
        for( int i = 0 ; i < n ; i++){
            if(arr[i] > 0){
                stack.push(arr[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek()>0 && Math.abs(arr[i])>stack.peek()){
                    stack.pop();
                }

                if(stack.isEmpty() ||stack.peek() < 0){
                  stack.push(arr[i]);
                }
                
                if(!stack.isEmpty() && stack.peek() == Math.abs(arr[i])) stack.pop();
            }
        }

       int[] ans = new int[stack.size()];

       for( int i = ans.length - 1 ; i >=0 ; i--){
          ans[i] = stack.pop();
       }

       return ans;
    }
}