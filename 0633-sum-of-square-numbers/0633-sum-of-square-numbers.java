class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int)Math.sqrt(c);

        while( a <= b){
            int sum = (int)(Math.pow(a,2) + Math.pow(b,2));

            if(sum == c){
                return true;
            }
            else if(sum < c){
                a++;
            }
            else b--;
        }

        return false;

        // Tc-> O(n) Sc-> O(1)
    }
}