class Solution {
    private static final long M = 1000000007L;
    long[][] PT ;

    private long solve( List<Integer> nums){
        int n = nums.size();
        if( n < 3) return 1;

        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();

        int root = nums.get(0);

        for( int i = 1; i < n ; i++){
            if( nums.get(i) < root){
                leftArray.add(nums.get(i));
            }
            else rightArray.add(nums.get(i));
        }

        long x = solve(leftArray) % M;
        long y = solve(rightArray) % M;

        // n-1 C leftarray.size() = Z we will calculate this efficiently using pascales triangle

        long z = PT[n-1][leftArray.size()]; // you can also take rightArray.size()

        return (((x * y) % M) * z) % M;


    }
    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Populating pascals triangle
        PT = new long[n+1][];

        for( int i = 0 ; i <= n ; i++){
            PT[i] = new long[i+1];
            Arrays.fill( PT[i] , 1L);

            for( int j = 1 ; j < i ; j++){
                PT[i][j] = (PT[i-1][j] + PT[i-1][j-1]) % M ;
            }
        }

        List<Integer> list = new ArrayList<>();

        for( int x : nums){
            list.add(x);
        }
        

        return (int) ( (solve(list) - 1 + M ) % M );

    }
}