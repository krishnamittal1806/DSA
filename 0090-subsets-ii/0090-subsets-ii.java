class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        findsubset(ans , new ArrayList<>() , 0 , arr);
        return ans;
    }

    private void findsubset( List<List<Integer>> ans , List<Integer> curr , int index , int[] arr)
    {
        ans.add( new ArrayList<>( curr));
       for( int i = index ; i < arr.length ; i++){
       if( i > index && arr[i] == arr[i-1]) continue; // handle suplicates
           
           curr.add(arr[i]);
           findsubset( ans , curr , i+1 , arr);
           curr.remove(curr.size() - 1);
       }
    }
}