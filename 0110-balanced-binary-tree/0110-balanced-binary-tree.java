/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        int depth = findDepth(root);

        if(depth == -1) return false;
        else return true;

    }

    private int findDepth(TreeNode root){
        if( root == null){
            return 0;
        }
        int lh = findDepth(root.left);
        int rh = findDepth(root.right);

        if(lh == -1 || rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh ,rh);  
    }
}