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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> bt=new ArrayList<>();
        postorder(root,bt);
        return bt;
    }
    private void postorder(TreeNode root,List<Integer> bt){
        if(root==null)return;
        postorder(root.left,bt);
        postorder(root.right,bt);
        bt.add(root.val);
    }
}