class Solution {
    public int[] asteroidCollision(int[] arr) {
       
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for( int i = 0 ; i < n ; i++){
            if(arr[i] > 0){
                stack.push(arr[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek()>0 && Math.abs(arr[i])>stack.peek()){
                    stack.pop();
                }

                if(stack.isEmpty() ||stack.peek() < 0){
                  stack.push(arr[i]);
                }
                
                if(!stack.isEmpty() && stack.peek() == Math.abs(arr[i])) stack.pop();
            }
        }

        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }

        Collections.reverse(ans);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}