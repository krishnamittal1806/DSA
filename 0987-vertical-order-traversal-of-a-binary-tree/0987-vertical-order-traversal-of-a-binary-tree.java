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

    class Pair{
        TreeNode node;
        int row;
        int col;

        public Pair(TreeNode node , int row , int col){
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if( root == null) return ans;

        // now we will use TreeMap to store elements in sorted manner by their col
        // also inside TreeMap we will have Priority Queue for (row , value) 
        // firstly we sort by rows , then for same row we sort by values
        TreeMap<Integer , PriorityQueue<int[]>> map = new TreeMap<>();
  
         // BFS : node , row , col
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root , 0 , 0));

        while ( !q.isEmpty()){
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;
            
            // making priorityQueue of this col
            map.putIfAbsent(col , new PriorityQueue<>(
            (a , b) -> {
                // Smaller rows first
                if(a[0] != b[0]) return Integer.compare(a[0] , b[0]);
                // if same row -> sort by values
                return Integer.compare(a[1] , b[1]);
            }
            ));

            map.get(col).offer(new int[]{row , node.val});

            if(node.left != null){
                q.offer(new Pair(node.left , row+1 , col-1));
            }

            if(node.right != null){
                q.offer(new Pair(node.right , row + 1 , col + 1));
            }
        }

        for( PriorityQueue<int[]> pq : map.values()){
            // create a list to store the elements at this col
            List<Integer> list = new ArrayList<>();

            while( !pq.isEmpty()){ // get elements from priority Queue highest priorrity element will come first

            list.add(pq.poll()[1]);

            }
            ans.add(list);
        }
        return ans;

    }
}