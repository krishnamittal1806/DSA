class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       // deque is the datastructure in which we can insert , delete or peek the elements from both front and back

       Deque<Integer> dq = new LinkedList<>();

       List<Integer> ans = new ArrayList<>();

       for( int i = 0; i < nums.length ; i++){
        if( !dq.isEmpty() && dq.peekFirst() <= i - k){
            dq.pollFirst();
        }

        while( !dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
            dq.pollLast();
        }
        dq.offerLast(i);

        if( i >= k - 1){
            ans.add(nums[dq.peekFirst()]);
        }
       }
       
       return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}