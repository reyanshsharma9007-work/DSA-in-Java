
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preorder(p).equals(preorder(q));
    }

    private List<Integer> preorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            ans.add(null);
            return ans;
        }

        ans.add(root.val);
        ans.addAll(preorder(root.left));
        ans.addAll(preorder(root.right));

        return ans;
    }
}