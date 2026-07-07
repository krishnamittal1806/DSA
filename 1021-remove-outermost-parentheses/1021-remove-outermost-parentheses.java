class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0 ;

        for( char ch : s.toCharArray()){
            if(ch == '('){
                level++;

                if(level > 1){
                    sb.append(ch);
                }
            }
            else {
              
                if(level > 1){
                    sb.append(ch);
                }
                level--;  

            }
        }
        return sb.toString();

    }
}