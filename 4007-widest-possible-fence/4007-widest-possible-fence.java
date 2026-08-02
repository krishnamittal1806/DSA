class Solution {
    public int maximumWidth(int[] planks) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> ans = new HashMap<>();

        for( int n : planks){
            count.put( n , count.getOrDefault(n , 0 ) + 1 );
            ans.put( n , ans.getOrDefault(n , 0 ) + 1 );
         }

        for( int a : count.keySet()){
            for( int b : count.keySet()){

                if( a ==  b){
                    ans.put(a+b , ans.getOrDefault( a + b , 0) + count.get(a) /2 );
                }

                if( a < b) {
                    ans .put( a+b , ans.getOrDefault(a+b , 0) + Math.min(count.get(a) , count.get(b)));

                }
            }
        }

         int maxWidth = 0;
        for( int num : ans.values()){
            maxWidth = Math.max(maxWidth , num);
        }

        return maxWidth;
    }
}