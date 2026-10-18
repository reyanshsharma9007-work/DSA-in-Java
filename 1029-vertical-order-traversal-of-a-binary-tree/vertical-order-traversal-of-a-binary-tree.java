
class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();

        q.add(new Object[]{root, 0, 0});

        while (!q.isEmpty()) {

            Object[] curr = q.poll();

            TreeNode node = (TreeNode) curr[0];
            int row = (int) curr[1];
            int col = (int) curr[2];

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            map.get(col).get(row).add(node.val);

            if (node.left != null) {
                q.add(new Object[]{node.left, row + 1, col - 1});
            }

            if (node.right != null) {
                q.add(new Object[]{node.right, row + 1, col + 1});
            }
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> rows
                : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> values : rows.values()) {

                while (!values.isEmpty()) {
                    column.add(values.poll());
                }
            }

            ans.add(column);
        }

        return ans;
    }
}
