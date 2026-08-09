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
 *         this.right = Tright;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
      int[] maxvalue = new int[1];
      maxvalue[0] = Integer.MIN_VALUE;
       maxSum(root , maxvalue);
       return maxvalue[0];
    }

    private  int maxSum( TreeNode node , int maxvalue[]){
        if( node == null) return 0;

        int leftSum = Math.max( 0 , maxSum(node.left , maxvalue));
        int rightSum = Math.max( 0 , maxSum( node.right , maxvalue));

        maxvalue[0] = Math.max(maxvalue[0] , leftSum + rightSum + node.val);

        return Math.max(leftSum , rightSum) + node.val;
    }

}