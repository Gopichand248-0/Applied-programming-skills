class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            result.add(column);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col,
                     TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(node.val);

        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}
