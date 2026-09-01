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
    public TreeNode deleteNode(TreeNode root, int key) {
        if( root == null) return null;

        if( root.val == key) return delete(root);

        TreeNode temp = root;
        while( root != null){
            if( root.val > key){
                if( root.left!= null && root.left.val == key){
                    root.left = delete(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }

            else{
                if( root.right != null && root.right.val == key){
                    root.right = delete(root.right);
                    break;
                }
                else {
                    root = root.right;
                }
            }
        }
        return temp;
    }
    private TreeNode delete(TreeNode node){
        if( node.left == null){
            return node.right;
        }
        if( node.right == null) return node.left;

        TreeNode rightchild = node.right;
        TreeNode lastright = findlastright(node.left);
        lastright.right = rightchild;
        return node.left;
    }
    private TreeNode findlastright(TreeNode node){
        if( node.right == null){
            return node;
        }
        return findlastright(node.right);
    }
}