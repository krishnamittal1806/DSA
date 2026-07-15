class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque <Integer> dq = new LinkedList<>();
       int n = nums.length;
       List<Integer> list = new ArrayList<>();

       for( int i = 0 ; i < nums.length ; i++){
        
        // If the window length exceeds k remove element from front
        if(!dq.isEmpty() && dq.peekFirst() <= i - k){
            dq.pollFirst();
        }

        // check if the element at the back of dq is smaller no point of keeping it remove.
        while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
            dq.pollLast();
        }
        dq.offerLast(i);

        // when first window is formed start adding answers to the list.
        // answer of every window is maintained at the fromt of deque.
        if(i >= k - 1){
            list.add( nums[dq.peekFirst()] );
        }
       }

       return list.stream().mapToInt(Integer::intValue).toArray();
    }
}