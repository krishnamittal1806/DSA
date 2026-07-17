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
    public int maxDepth(TreeNode root) {
       
        Queue<TreeNode>  q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        if( root == null) return depth;

        while( !q.isEmpty()){
            int level_size = q.size();
            depth++;

            for( int i = 0; i<level_size; i++){
                TreeNode temp = q.remove();

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }

        return depth;
    }
}