class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length ;
        int ans = 0; int maxe = Integer.MIN_VALUE;
        for( int i = 0; i < nums.length ; i++){
            maxe = Math.max(nums[i] , maxe);
        }

        for( int i = 0; i < n ; i++){
            ans += maxe - nums[i];
        }
        return ans;
    }
}