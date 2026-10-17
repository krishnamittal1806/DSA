class Solution {
    private int digitsum( int n ){
        int sum = 0;
        while( n > 0){
            int rm = n % 10;
            sum += rm ;
            n = n / 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][2];

        for( int i = 0 ; i < n ; i++){
            arr[i][0] = nums[i];
            arr[i][1] = digitsum(nums[i]);
        }

        Arrays.sort(arr , ( a , b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        Map<Integer,Integer> map = new HashMap<>();

        for( int i = 0;i < n ; i++){
            map.put( nums[i] , i);
        }
        int swaps = 0;

        for( int i = 0; i < n ; i++){
            int correctIndex = map.get(arr[i][0]);

            if( correctIndex != i ){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

                map.put(nums[correctIndex] , correctIndex);
                map.put(nums[i] , i);

                swaps++;

            }
        }
        return swaps;
    }
}