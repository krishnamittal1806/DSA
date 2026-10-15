class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        
        for( int i = 0; i < n ; i++){
            boolean[] seen = new boolean[101];
            int distinct = 0;
            for( int j = i ;j < n ; j++){
                if( !seen[nums.get(j)]){
                    distinct++;
                    seen[nums.get(j)] = true;
                }
                ans += distinct * distinct;
            }
        }

        return ans;

        // time complexity -> O(n^2)
        // space complexity - O(n)
   }
}