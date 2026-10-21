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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)map.put(inorder[i],i);
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }

    TreeNode build(int[] in,int inStart,int inEnd,int[] post,int poStart,int poEnd,Map<Integer,Integer>map){
        if(inStart>inEnd || poStart>poEnd)return null;
        TreeNode root=new TreeNode(post[poEnd]);
        int index=map.get(root.val);
        int left=index-inStart;
        root.left=build(in,inStart,index-1,post,poStart,poStart+left-1,map);
        root.right=build(in,index+1,inEnd,post,poStart+left,poEnd-1,map);
        return root;
    }
}