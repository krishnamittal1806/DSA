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
    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        while( !stack.isEmpty()){
            TreeNode element = stack.pop();
            ans.add(element.val);

            if( element.right != null) stack.push(element.right);
            if( element.left != null) stack.push(element.left);

        }

        return ans;  
    }
}