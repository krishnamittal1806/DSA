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
    private static int findtime(HashMap<TreeNode , TreeNode> parentmap , TreeNode target ){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        HashMap<TreeNode , Integer > visited = new HashMap<>();

        visited.put(target , 1);
        int time = 0;

        while( !q.isEmpty()){
            int size = q.size();
            int fl = 0;

             for( int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();

                if(node.left != null && visited.get(node.left) == null){
                    q.offer( node.left);
                    visited.put(node.left , 1);
                    fl = 1;
                }
                if(node.right != null && visited.get(node.right) == null){
                    q.offer( node.right);
                    visited.put(node.right , 1);
                    fl = 1;
                }
                if(parentmap.get(node) != null && visited.get(parentmap.get(node)) == null ){
                    q.offer( parentmap.get(node));
                    visited.put(parentmap.get(node) , 1);
                    fl = 1;
                }
            }
            if (fl == 1 ) time++;
        }
        return time;
    }

    private static TreeNode markparent(TreeNode root ,
     HashMap<TreeNode , TreeNode> parentmap , int start){
        TreeNode res = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while( !q.isEmpty()){
            TreeNode curr = q.poll();

            if( curr.val == start){
                res = curr;
            }
            if( curr.left != null){
                q.offer(curr.left);
                parentmap.put( curr.left , curr);

            }
            if( curr.right != null){
                q.offer(curr.right);
                parentmap.put( curr.right , curr);

            }
        }
        return res;
    }
    public int amountOfTime(TreeNode root, int start) {
    HashMap<TreeNode,TreeNode> parentmap = new HashMap<>();
    
    TreeNode target = markparent(root , parentmap , start );

    return findtime(parentmap , target);
        
    }
}