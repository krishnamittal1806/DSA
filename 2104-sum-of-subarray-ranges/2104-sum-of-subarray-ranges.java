class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        int[] nse = findnse(arr);
        int[] pse = findpse(arr);
        int[] nge = findnge(arr);
        int[] pge = findpge(arr);
        long minsum = 0;
        long maxsum = 0;
        long ans = 0;

        for( int i = 0 ; i < n ; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left * right;

            minsum = ( minsum + (freq *arr[i]) );
        }
        for( int i = 0 ; i < n ; i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            long freq = left * right;

            maxsum = ( maxsum + (freq *arr[i]) );
        }

        return maxsum - minsum;

        
        
    }
    private int[] findnse(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for( int i = n-1 ; i >=0 ; i--){
            while( !stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : n;
            stack.push(i);
        }

        return ans;
    }
    private int[] findpse(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for( int i = 0 ; i < n ; i++){
            while( !stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }

        return ans;
    }
    private int[] findnge(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for( int i = n-1 ; i >=0 ; i--){
            while( !stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : n;
            stack.push(i);
        }

        return ans;
    }
     private int[] findpge(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for( int i = 0 ; i < n ; i++){
            while( !stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }

        return ans;
    }

}