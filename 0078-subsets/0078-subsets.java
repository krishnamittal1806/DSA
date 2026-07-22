class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        findsubsets(arr , ans , new ArrayList<>() , 0);

        return ans;

    }

    private void findsubsets(int[] arr , List<List<Integer>> ans , List<Integer> curr , int index ){

        if( index == arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        } // choice to pick
            curr.add(arr[index]);
            findsubsets( arr , ans , curr , index + 1 );
            curr.remove(curr.size() - 1);
            // choice to not pick
            findsubsets( arr , ans , curr , index + 1 ); 
    }
}