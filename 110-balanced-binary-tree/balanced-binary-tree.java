class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left - right) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    int height(TreeNode root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}