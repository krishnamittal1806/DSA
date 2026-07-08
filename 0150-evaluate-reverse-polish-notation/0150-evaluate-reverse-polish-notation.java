class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int op1 =0 ;int op2= 0;

        for( String token : tokens){
            if(token.equals("+")){
               op1 = stack.pop();
               op2 = stack.pop();

               stack.push(op2 + op1);
            }
            else if(token.equals("-")){
               op1 = stack.pop();
               op2 = stack.pop();

               stack.push(op2 - op1);
            }
            else if(token.equals("*")){
               op1 = stack.pop();
               op2 = stack.pop();

               stack.push(op2 * op1);
            }
            else if(token.equals("/")){
               op1 = stack.pop();
               op2 = stack.pop();

               stack.push(op2 / op1);
            }

            else stack.push(Integer.parseInt(token));
            
        }

        return stack.pop();
    }
}