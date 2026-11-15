class Solution {
    int M = 1000000007;
    public int numOfSubarrays(int[] nums) {
       int n = nums.length;
       int sum = 0;
       int count= 0; int even = 1 ; int odd = 0;

       for( int i = 0; i < n ; i++){
        sum += nums[i];
        if(sum % 2 == 0 ) {
            // even + odd = odd -> store that in count
            count = ( count + odd) % M;
            even++;
        }
        else {
            // odd + even = odd -> store these also in count
            count = ( count + even) % M;
            odd++;
        }
       }

       return count;
    }
}