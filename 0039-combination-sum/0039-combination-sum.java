class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        validsum(ans , curr , candidates , 0 , target);
        return ans;
    }

    private void validsum( List<List<Integer>> ans, List<Integer> curr , int[] candidates , int index , int target){

        if( index == candidates.length){
            if( target == 0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if( candidates[index] <= target){ // choice to pick element 
            curr.add(candidates[index]);
            validsum(ans , curr , candidates , index , target - candidates[index]);
            curr.remove(curr.size() - 1);
        }
        validsum(ans , curr , candidates , index + 1 , target);
    }
}