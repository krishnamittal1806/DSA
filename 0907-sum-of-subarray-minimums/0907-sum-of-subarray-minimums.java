class Solution {
    public int sumSubarrayMins(int[] arr) {

       int[] nse = findnse(arr);
       int[] psee = findpsee(arr);
       int ans = 0 ;
       int M = 1000000007;

       for( int i = 0 ; i < arr.length ; i++){
        int left = i - psee[i];
        int right = nse[i] - i;
        long freq = (left * right);

        ans = ( ans + (int)(( freq * arr[i] ) % M )) % M;
        
       }

       return  ans;
    }

    private int[] findnse(int[] arr){
        int n = arr.length;
        int [] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for( int i = n - 1 ; i >= 0 ; i--){
          while( !stack.isEmpty() && arr[stack.peek()] >= arr[i]){
            stack.pop();
          }

          ans[i] = !stack.isEmpty() ? stack.peek() : n;

          stack.push(i);
        }

       return ans;
    }

    private int[] findpsee(int[] arr){
        int n = arr.length ;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for( int i = 0 ; i < n ; i++){
            while( !stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }

        return ans;
    }
}