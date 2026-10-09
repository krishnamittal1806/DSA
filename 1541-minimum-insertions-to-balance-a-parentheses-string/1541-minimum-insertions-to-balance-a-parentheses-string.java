class Solution {
    public int minInsertions(String s) {
        int ops  = 0;
        int open = 0; 
        int i = 0;
        while(i  < s.length()){
            if( s.charAt(i) == '('){
                open++;
                i++;
            }
            else {

                if( i < s.length() - 1 && s.charAt(i+1) == ')'){
                    open--;
                    if( open < 0){
                        ops += 1;
                        open  = 0;
                    }
                    i+=2;
                }
                else {
                    ops += 1;
                    open--;

                    if(open < 0){
                        ops+=1;
                        open = 0;
                    }
                    i++;
                }
            }
        }

        // now for all the remaining open add corresponding 2 closing ones\
        ops += 2 * open;

        return ops;
    }
}