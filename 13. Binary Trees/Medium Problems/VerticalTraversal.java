import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class VerticalTraversal {

    class Pair {
        int h, level;
        TreeNode node;

        Pair(int h, int level, TreeNode node) {
            this.h = h;
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode node) {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Pair>> map = new TreeMap<>();

        queue.add(new Pair(0, 0, node));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            map.putIfAbsent(curr.h, new ArrayList<>());
            map.get(curr.h).add(curr);

            if (curr.node.left != null) {
                queue.add(new Pair(curr.h - 1, curr.level + 1, curr.node.left));
            }
            if (curr.node.right != null) {
                queue.add(new Pair(curr.h + 1, curr.level + 1, curr.node.right));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (ArrayList<Pair> column : map.values()) {
            Collections.sort(column, (a, b) -> a.level == b.level ? a.node.val - b.node.val : a.level - b.level);
            List<Integer> sortedColumn = new ArrayList<>();
            for (Pair p : column) {
                sortedColumn.add(p.node.val);
            }
            ans.add(sortedColumn);
        }
        return ans;
    }

}
