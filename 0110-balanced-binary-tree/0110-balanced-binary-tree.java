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
        if( root == null) return true;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode element = stack.pop();

            if(element.left != null) stack.push(element.left);
            if(element.right != null) stack.push(element.right);
            
            int lh = findDepth(element.left);
            int rh = findDepth(element.right);

            if( Math.abs(lh - rh) > 1) return false;
        }

        return true;

    }

    private int findDepth(TreeNode root){
        if( root == null){
            return 0;
        }
        int lh = findDepth(root.left);
        int rh = findDepth(root.right);
        return 1 + Math.max(lh ,rh);  
    }
}