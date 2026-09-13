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
    public TreeNode bstFromPreorder(int[] preorder) {
       
        int[] pre = preorder.clone();

        Arrays.sort(preorder);

        Map<Integer, Integer> inmap = new HashMap<>();
        for( int i = 0; i < preorder.length ; i++){
            inmap.put(preorder[i] , i);
        }

        TreeNode root = buildTree( pre , 0 , pre.length - 1 , preorder ,0, preorder.length - 1, inmap);
        return root;
    
    }
    private TreeNode buildTree( int[] pre , int prestart , int preend , int[] inorder , int instart , int inend , Map<Integer,Integer> inmap){
        if(prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(pre[prestart]);

        int inRoot = inmap.get(root.val);
        int numsleft = inRoot - instart;

        root.left = buildTree(pre , prestart + 1 , prestart + numsleft , inorder , instart , inRoot - 1 , inmap);

        root.right = buildTree(pre , prestart + numsleft + 1 , preend, inorder , inRoot + 1 , inend , inmap);

        return root;
    
    }
}