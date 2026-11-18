class Solution {
    public int minChanges(String s) {
        // brute force approach
        int ops = 0;
        int n = s.length();

        int i = 0; int j = 1;

        while( j < n && i < n){
            if(s.charAt(j) != s.charAt(i)){
                ops++;
            }
            i += 2;
            j +=2 ;
        }
        return ops;
    }
}