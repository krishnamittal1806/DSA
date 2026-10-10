class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
    int n = nums1.length;
    int maxdiff = 0;

    for( int i = 0 ; i < n ; i++){
        maxdiff = Math.max(maxdiff , Math.abs(nums1[i] - nums2[i]));
    }

    int[] countdiff = new int[maxdiff + 1];
    for( int i = 0 ; i < n ; i++ ){
        int d = Math.abs(nums1[i] - nums2[i]);
        countdiff[d]++;
    }

    long k = (long) k1+k2;

    for( int currdiff = maxdiff ; currdiff > 0 && k > 0 ; currdiff--){
        int countops = (int) Math.min(k , countdiff[currdiff]);
        countdiff[currdiff] -= countops;
        countdiff[currdiff-1] += countops;
        k -= countops;
    }

    long result = 0;
    for( int diff = 1 ; diff <= maxdiff ; diff++){
        result += (long) countdiff[diff] * diff * diff; 
    }
    return result;
    }
}