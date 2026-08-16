class Solution {
    public int minPenalty(int period, int[] lights, int[] arr) {
        int ans = 0;
        int maxlight = 0;
        for( int n : lights){
            maxlight = Math.max (maxlight , n);
        }

        for( int i = 0; i < arr.length ; i++){
            int wt = 0;
            int r = arr[i] % period;
            if(r < maxlight){
                wt = 0;
            }
            else wt = period - r;

            ans = Math.max(ans , wt);
        }

        return ans;

    }
}