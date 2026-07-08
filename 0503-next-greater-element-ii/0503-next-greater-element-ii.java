class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        int n = nums.length;
        int[] ans = new int[n];
        stack.push(nums[n-1]);

        for( int i = 2*n - 2 ; i >= 0 ; i-- ){

            while(!stack.isEmpty() ){
                int top = stack.peek();

                if( top > nums[i % n]){
                    ans[i % n] = top;
                    break; 
                }
                else stack.pop();                
                
            }

            if(stack.isEmpty()){
                ans[i % n] = -1;
            }

            stack.push(nums[i % n]);
        }

        return ans;       
    }
}