import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    // List<List<Integer>> result = new ArrayList<>();
    // if (root == null) return result;
    // levelOrderTraversal(root, result, 0);
    // return result;
    // }

    // public void levelOrderTraversal(TreeNode root, List<List<Integer>> result,
    // int level) {
    // if (root == null) return;

    // if (result.size() == level) {
    // result.add(new ArrayList<>());
    // }

    // result.get(level).add(root.val);

    // levelOrderTraversal(root.left, result, level + 1);
    // levelOrderTraversal(root.right, result, level + 1);
    // }
}
