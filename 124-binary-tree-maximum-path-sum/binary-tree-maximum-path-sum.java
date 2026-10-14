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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        rootSum(root);
        return maxi;
    }
    int rootSum(TreeNode root){
        if(root==null)return 0;
        
        int leftSum = Math.max(0, rootSum(root.left));
        int rightSum = Math.max(0, rootSum(root.right));
        maxi=Math.max(maxi,(root.val+leftSum+rightSum));
        return (root.val)+Math.max(leftSum,rightSum);

    }
}