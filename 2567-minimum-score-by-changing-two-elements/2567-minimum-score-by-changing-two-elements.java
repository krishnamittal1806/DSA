class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int high = Integer.MAX_VALUE;
        // 1st case 
        high = Math.min(high , nums[nums.length - 2] - nums[1]);
        // 2nd case
        high = Math.min( high , nums[nums.length - 3] - nums[0]);
        // 3rd case
        high = Math.min(high , nums[nums.length - 1] - nums[2]);
        return high;
    }
}