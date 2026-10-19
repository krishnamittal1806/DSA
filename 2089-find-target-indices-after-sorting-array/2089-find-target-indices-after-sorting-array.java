class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
       List<Integer> ans = new ArrayList<>();

       int targetcount = 0;
       int smallcount = 0;
       for( int i = 0 ; i< nums.length; i++){
        if( nums[i] == target) targetcount++;
        else {
            if( nums[i] < target) smallcount++;
        }
       }

      for( int i = 0; i < targetcount ; i++){
        ans.add(smallcount + i);
      }

      return ans;
    }
}