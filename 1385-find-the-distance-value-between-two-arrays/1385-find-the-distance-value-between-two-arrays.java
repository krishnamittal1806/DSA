class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length ; 
        for( int i = 0; i < arr1.length ; i++){
            int j = 0; 

            while( j < arr2.length){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    count--;
                    j = arr2.length;
                }
                else {
                    j++;
                }
            }
        }
        return count;  
    }
}