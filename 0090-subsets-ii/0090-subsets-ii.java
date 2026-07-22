class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        findsubset(ans , new ArrayList<>() , 0 , arr);
        return ans;
    }

    private void findsubset( List<List<Integer>> ans , List<Integer> curr , int index , int[] arr)
    {
        if( index == arr.length){
            if( !ans.contains(curr)){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(arr[index]);
        findsubset( ans , curr , index + 1 , arr);
        curr.remove( curr.size() - 1);

        findsubset( ans , curr , index+1 , arr);
    }
}