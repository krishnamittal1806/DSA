class Solution {
    Set<String> ans = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftrem = 0; int rightrem = 0;

        for(char ch : s.toCharArray()){
            if( ch == '(') leftrem++;
            else if( ch == ')'){
                if(leftrem > 0) leftrem --;
                else rightrem++;
            }
        }
        solve(s , 0 , 0 , leftrem , rightrem , new StringBuilder());

        return new ArrayList<>(ans);
    }

    private void solve( String s , int index , int balance , int leftrem , int rightrem , StringBuilder current){
        if( balance < 0) return ;

        if( index == s.length()){
           if( balance == 0 && leftrem == 0 && rightrem == 0) {
            ans.add(current.toString());
           }
           return;
        }

        if(s.charAt(index) == '('){
            // select 
            current.append(s.charAt(index));
            solve( s , index + 1 , balance + 1 , leftrem , rightrem , current);
            current.deleteCharAt(current.length() - 1);

            // remove
            if(leftrem > 0){
                solve( s , index + 1 , balance , leftrem-1 , rightrem , current);
            }

        }
        else if(s.charAt(index) == ')'){
             // select 
            if( balance > 0){
                current.append(s.charAt(index));
                solve( s , index + 1 , balance - 1 , leftrem , rightrem , current);
                current.deleteCharAt(current.length() - 1);
            }
        
            // remove
            if(rightrem > 0){
                solve( s , index + 1 , balance , leftrem , rightrem - 1 , current);
            }

        }
        else {
            current.append(s.charAt(index));
            solve(s , index + 1 , balance , leftrem , rightrem , current);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}