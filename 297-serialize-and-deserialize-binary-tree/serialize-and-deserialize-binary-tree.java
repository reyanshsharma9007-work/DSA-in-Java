/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    if (root == null) return "";

    StringBuilder s = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        TreeNode p = q.poll();

        if (p == null) {
            s.append("null ");
            continue;
        }

        s.append(p.val).append(" ");

        q.add(p.left);
        q.add(p.right);
    }

    return s.toString();
}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty())return null;
        String[] arr=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(i<arr.length && !arr[i].equals("null")){
                node.left=new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.left);
            }
            i++;

            if(i<arr.length && !arr[i].equals("null")){
                node.right=new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.right);
            }
            i++;

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));