class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // brute force -> O(n^2)
      
        int[] result = new int[nums1.length];
        for( int i = 0; i < nums1.length ; i++){
            int index = -1;
            for( int j = 0 ; j < nums2.length ; j++){
                 
                 if( nums1[i] == nums2[j]){
                    index = j;
                    break;
                 }
            }
            int nextGreater = -1;

            for( int j = index + 1 ; j < nums2.length ; j++){
                if(nums2[j] > nums1[i]){
                    nextGreater = nums2[j];
                    break;
                }
                
            }
            result[i] = nextGreater;

        }

       return result;
    }
}