class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
       int ans = Integer.MAX_VALUE ;
       int n = nums.size();

       int[] prefix = new int[n+1];
       for( int i = 0 ; i < n ; i++){
        prefix[i+1] = prefix[i] + nums.get(i);
       }

       for( int i = 0; i < n; i++){
        int sum = 0;
        for( int len = l  ; len <= r && (i + len <= n); len++){
           int j = i + len;
           sum = prefix[j] - prefix[i];

           if( sum > 0){
            ans = Math.min( ans , sum);
           }
        }
       }
       return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}