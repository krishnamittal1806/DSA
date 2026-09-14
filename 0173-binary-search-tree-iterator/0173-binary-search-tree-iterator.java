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
class BSTIterator {

    // brute force -> store the inorder of BST in a list and then implement next and hasnext
    // time -> O(1) , space - O(N) , where N = no. of nodes

    List<Integer> list = new ArrayList<>();
    private int p = -1;

    public BSTIterator(TreeNode root) {
        inorder( root , list);
    }
    
    public int next() {
        p++;
        return list.get(p); 
    }
    
    public boolean hasNext() {
       return (p + 1 < list.size() );
    }

    public void inorder( TreeNode root , List<Integer> list){
        if( root == null) return;
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */