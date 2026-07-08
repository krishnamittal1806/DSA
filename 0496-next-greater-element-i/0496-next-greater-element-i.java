class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Stack<Integer> stack = new Stack<>();
       HashMap<Integer,Integer> map = new HashMap<>();
    

       stack.push(nums2[nums2.length - 1]);
       map.put(nums2[nums2.length -1 ] , -1);
       

       for( int i = nums2.length - 2 ; i >=0 ; i--){
            int top = stack.peek();
            if(nums2[i] < top){
                map.put(nums2[i] , top );
            }

            else {
                while(!stack.isEmpty()){
                    top = stack.peek();
                    if(top > nums2[i]){
                        map.put(nums2[i] , top);
                        break;
                    }
                    else stack.pop();

                }

                if(stack.isEmpty()){
                    map.put(nums2[i] , -1);
                }
                

            }

            stack.push(nums2[i]);
        }

      int ans[] = new int[nums1.length];
      for( int i = 0 ; i < nums1.length ; i++){
           ans[i] = map.get(nums1[i]);
      }

       return ans;
    }
}