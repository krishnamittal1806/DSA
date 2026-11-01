class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for( int n : nums){
            min = Math.min(min , n);
            sum += n;
        }
        int ans = sum - nums.length * min;

        return ans;

    }
}