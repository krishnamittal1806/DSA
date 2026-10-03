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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue <TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if( root == null) return ans;

        q.offer(root);

        while(!q.isEmpty()){

            int levelnodes = q.size(); // we have to calculate total nodes at each level to iterate through them
            List<Integer> sublist = new ArrayList<>(); // becuase at every new level we need new list

            for( int i = 0 ; i< levelnodes ; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                sublist.add(q.poll().val);
            }
            ans.add(sublist);
            
        }

        return ans;
    }
}