class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generate( n , 0 , 0 , sb , list);
        return list;
         
    }
    private void generate( int n , int open , int close , StringBuilder sb  , List<String> list){

        if( sb.length() == 2 * n){
            list.add(sb.toString());
            return;
        }

        if( open < n){
            sb.append('(');
            generate( n , open + 1 , close , sb , list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if( close < open){
            sb.append(')');
            generate( n , open  , close + 1 , sb , list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}