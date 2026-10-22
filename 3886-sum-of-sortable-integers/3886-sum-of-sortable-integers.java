class Solution {
    private void computeLPS(int[] pattern , int[] lps){
        int m = pattern.length;

        int len = 0;
        lps[0] = 0;

        int i = 1;

        while( i < m){
            if( pattern[i] == pattern[len]){
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if( len != 0){
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    private boolean KMP( int[] pat , int[] txt){
        int n = txt.length; int m = pat.length;

        int[] lps = new int[m];
        computeLPS(pat , lps);

        int i = 0; int j = 0;

        while( i < n){
            if( pat[j] == txt[i]){
                i++;
                j++;
            }
            if(j == m){
                return true; // found 
            }
            else if( i < n && pat[j] != txt[i]){
                if( j != 0){
                    j = lps[j-1];
                }
                else i++;
            }
        }

        return false;
    }
    private boolean isRotation(int[] vec1 , int[] vec2){
        int[] temp = new int[vec2.length * 2];
        System.arraycopy(vec2 , 0 , temp , 0 , vec2.length);
        System.arraycopy(vec2 , 0 , temp , vec2.length , vec2.length);

        return KMP(vec1 , temp);
    }
    public int sortableIntegers(int[] nums) {
        int n = nums.length; 

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for( int k = 1 ; k <= n; k++){
            if( n % k != 0) continue;

            boolean valid = true;

            for( int start = 0 ; start < n ; start += k){
                int[] vec1 = Arrays.copyOfRange(nums , start , start + k);
                int[] vec2 = Arrays.copyOfRange(sorted , start , start + k);

                if( !isRotation(vec1 , vec2)){
                    valid = false;
                    break;
                }
            }
            if(valid) {
                ans += k;
            }
        }

        return ans;
    }
}