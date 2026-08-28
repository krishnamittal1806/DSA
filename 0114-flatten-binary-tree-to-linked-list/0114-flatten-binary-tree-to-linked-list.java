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
    public void flatten(TreeNode root) {
       // brute force approach I can think is traverse the tree store the npdes in Queue and then link them

       Queue<TreeNode> q = new LinkedList<>();
       insert( root , q);
       q.poll();
       while( ! q.isEmpty()){
        root.right = q.poll();
        root.left = null;
        root = root.right;
       }
    }
    private void insert( TreeNode root, Queue <TreeNode> q ){
        // using preorder traversal to insert the nodes into the queue
        if( root == null) return;
        q.offer(root);
        insert(root.left , q);
        insert(root.right , q);
    }
}