/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markparents(TreeNode root , Map<TreeNode , TreeNode> parent_map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while( !q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr.left!= null){
                parent_map.put(curr.left , curr);
                q.offer(curr.left);
            }

            if( curr.right != null){
                parent_map.put(curr.right , curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode > parentmap = new HashMap<>();
        markparents(root , parentmap);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode , Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target , true);
        int currlevel = 0;

        while( !q.isEmpty()){
            int size = q.size();
            if( currlevel == k) break;
            currlevel++;

            for( int i = 0 ; i< size ; i++){
                TreeNode curr = q.poll();

                if(curr.left != null && visited.get(curr.left) == null){
                    q.offer(curr.left);
                    visited.put(curr.left , true);
                }

                if( curr.right != null && visited.get(curr.right) == null){
                    q.offer(curr.right);
                    visited.put(curr.right , true);
                }

                if( parentmap.get(curr) != null && visited.get(parentmap.get(curr)) == null){
                    q.offer(parentmap.get(curr));
                    visited.put(parentmap.get(curr) , true);

                }

            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            ans.add(current.val);
        }

        return ans;
    }
}