class Solution {
    public int maximumGap(String s, String st) {
        int n = s.length(); int m = st.length();

        int[] left = new int[n] ; // for earliest assignment of skill
        int[] right = new int[m]; // for as late assignment as possible

        int j = 0; // variable to track String (station)

        for( int i = 0 ; i < n ; i++){
            while( s.charAt(i) != st.charAt(j)) j++; // if characters are not equal move in string station 

            // if they both are equal then assign it to the left array
            left[i] = j;
            j++;

        }

        j = m - 1;
        for( int i = n - 1 ; i >= 0 ; i--){
            while( s.charAt(i) != st.charAt(j)) j--; // if characters are not equal move in string station 

            // if they both are equal then assign it i to right array
            right[i] = j;
            j--;

        }

        int ans = 0;
        for( int i = 0 ; i < n-1 ; i++){
            ans = Math.max( ans , right[i+1] - left[i]);  
            // here we are doing right[i+1] because right[i+1] contains the next farthest consecutive element and left[i] contains the earliest previous consecutive element 
        }
        return ans;
    }
}