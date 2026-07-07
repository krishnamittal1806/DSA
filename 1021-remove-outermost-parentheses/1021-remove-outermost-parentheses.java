class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        int start = 0;

        for( int i =0 ; i<s.length(); i++){
            if(s.charAt(i) == '(') stack.push(s.charAt(i));

            else {
                stack.pop();

                if(stack.isEmpty()){ // it means one decomposition is find time to remove 
                    for( int j = start + 1 ; j < i ; j++){
                        ans += s.charAt(j);
                    }
                    start = i + 1;
                }
            }

        }

        return ans;
    }
}