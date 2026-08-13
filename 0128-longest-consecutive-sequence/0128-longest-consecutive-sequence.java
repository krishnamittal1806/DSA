class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length ; i++){
            set.add(nums[i]);
        }

        int ans = 0 ;

        for( int n : set){
            if( !set.contains(n-1)){
                int m = n + 1;
                while( set.contains(m)){
                    m++;
                }

                ans = Math.max(ans , m - n);
            }

        }
        return ans;
        
    }
}