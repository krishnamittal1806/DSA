class Solution {
    public int scoreOfParentheses(String s) {
       int depth = 0;
       int ans = 0;

       for( int i = 0; i < s.length() ; i++){
        if( s.charAt(i) =='('){
            depth++;
        }
        else {
            depth = depth - 1;

            if( s.charAt(i-1) == '('){ // found the pair
                ans += Math.pow( 2 , depth);
            }
        }
       }
       return ans;

    }
}