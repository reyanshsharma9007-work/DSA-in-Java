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
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root,root,k);
    }
    private boolean dfs(TreeNode root,TreeNode current,int k){
        if(current==null)return false;
        int req=k-current.val;
        //Search For Required 
        if(req!=current.val && search(root,req))return true;
        return dfs(root,current.left,k)|| dfs(root,current.right,k);
    }

    private static boolean search(TreeNode root,int target){
        while(root!=null){
            if(root.val==target)return true;
            if(target<root.val)root=root.left;
            else root=root.right;
        }
        return false;
    }
}