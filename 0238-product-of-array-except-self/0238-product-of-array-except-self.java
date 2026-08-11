class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0; int prod = 1;
        int count0 = 0;

        for( int i = 0 ; i < nums.length ; i++){
            if( nums[i] == 0){
                count0++;
                index = i;
            }
            else prod = prod * nums[i];
            
        }

        if( count0 == 1){
            ans[index] = prod;
            return ans;
        } 

        if( count0 > 1){
            return ans;
        }

        for( int i = 0 ; i < nums.length ; i++){
            ans[i] = prod / nums[i];
        }
        return ans;
    }
}