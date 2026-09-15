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

    // brute force approach store the inorder traversal , sort that traversal and then run two pointers one on sorted inorder , one on actual tree , whenever their is violation with that swap it 
    // time O(nlogn + 2n) space - O(n)
        
    private TreeNode first = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    private TreeNode second = null;
    private TreeNode middle;

    private void inorder( TreeNode root){
        if( root == null) return;

        inorder( root.left);

        // business logic
        if( first == null && (prev.val > root.val) ){
            first = prev;
        }

        if( first != null && (prev.val > root.val)){
            second = root;
        }
        prev = root;

        inorder( root.right);
        
    }
    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;       
    }
}