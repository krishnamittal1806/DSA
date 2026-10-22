class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int asc_count = 0;
        int desc_count  = 0;

        for( int i = 1; i < n ; i++){
            if( nums[i] == (nums[i-1] + 1) % n ) asc_count++;
            if( nums[i-1] == (nums[i] + 1) % n) desc_count++;
        }

        if( asc_count == n-1 && nums[0] == 0) return 0 ;

        if( asc_count == n-1){
            int leftrot = n - nums[0];
            int rightrot  = 1 + (nums[nums.length-1] + 1) + 1;

            return Math.min(leftrot , rightrot);
        }

        if( desc_count == n-1){

            int leftrot = n - nums[nums.length-1] + 1;
            int rightrot = (nums[0] + 1 ) % n + 1;

            return Math.min(leftrot , rightrot);

        }
        return -1;

    }
}