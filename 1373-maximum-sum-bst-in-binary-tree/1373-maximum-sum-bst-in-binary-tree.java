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

class NodeValue {
    public int minNode , maxNode , sum , maxsum;

    public NodeValue(int minNode , int maxNode , int sum , int maxsum){
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
        this.maxsum = maxsum;
    }
}
class Solution {

    private NodeValue helper( TreeNode root){
        if( root == null){
            return new NodeValue(Integer.MAX_VALUE , Integer.MIN_VALUE ,0,0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if( left.maxNode < root.val && right.minNode > root.val){
            // it is a bst
            int sum = root.val + left.sum + right.sum;

            return new NodeValue(Math.min(root.val , Math.min(left.minNode , right.minNode)) , Math.max(root.val , Math.max ( left.maxNode , right.maxNode)) , sum , Math.max( 0 , Math.max( sum , Math.max(left.maxsum , right.maxsum))));
        }

        return new NodeValue(Integer.MIN_VALUE , Integer.MAX_VALUE , 0 , Math.max(left.maxsum , right.maxsum));
    }
    public int maxSumBST(TreeNode root) {
        return helper(root).maxsum;
    }
}