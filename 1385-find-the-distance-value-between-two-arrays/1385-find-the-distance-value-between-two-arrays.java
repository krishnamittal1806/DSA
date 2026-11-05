class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length ; 
        Arrays.sort(arr2);
        for( int i = 0; i < arr1.length ; i++){
            int l = 0;
            int h = arr2.length;

            while(l < h) {
                int mid = l + (h - l) / 2;
                if (arr2[mid] < arr1[i] - d) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }
            if(l < arr2.length && arr2[l] <= arr1[i] + d) {
                count--;
            }
        }
        return count;  
    }
}