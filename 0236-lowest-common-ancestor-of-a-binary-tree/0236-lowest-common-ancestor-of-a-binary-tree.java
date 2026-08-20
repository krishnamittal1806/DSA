/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // brute force approach 

        List<TreeNode> pathp = new ArrayList<>();
        List<TreeNode> pathq = new ArrayList<>();

        findpath(root , p , pathp);
        findpath(root , q , pathq);

        TreeNode ans = null;
        int i = 0;

        while(i < pathp.size() && i < pathq.size() && pathp.get(i) == pathq.get(i)){
            ans = pathp.get(i);
            i++;
        }

        return ans; 

    }
    private boolean findpath( TreeNode root , TreeNode target , List<TreeNode> path){
        if( root == null){
            return false;
        }
        path.add(root);

        if(root == target){
            return true;
        }
        if( findpath(root.left , target , path) || findpath(root.right, target , path) ){
            return true;
        }

        path.remove(path.size() - 1);
        return false;

    }
}