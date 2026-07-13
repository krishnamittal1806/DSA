class Solution {
    public int trap(int[] arr) {
        // optimized approach 
        //time -> O(n) , space -> O(1)
        int n = arr.length;

        int lmax = 0; int rmax = arr[n-1]; int l = 0 ; int r = n - 1;
        int total = 0;

        while( l < r){
            if(arr[l] <= arr[r]){
                if(lmax >= arr[l]){
                    total += lmax - arr[l];
                }

                else lmax = arr[l];
                l = l + 1;
            }

            else{
                if(rmax >= arr[r]){
                    total += rmax - arr[r];
                }
                else {
                    rmax = arr[r];
                }
                r = r - 1;
            }
        }

        return total;

    }
}