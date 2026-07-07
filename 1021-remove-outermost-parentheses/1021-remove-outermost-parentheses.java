class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        String ans = "";


        for( int i = 0 ; i<s.length(); i++){
            if(s.charAt(i) == '(' ) {
                
                stack.push(s.charAt(i));

                if(stack.size() > 1){
                   ans += s.charAt(i);
                }
            }

            else {

                if(stack.size() > 1){
                   ans += s.charAt(i);
                }
                stack.pop();
            }

        }

        return ans;
    }
}