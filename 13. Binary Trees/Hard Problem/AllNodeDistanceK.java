import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class AllNodeDistanceK {

    static HashMap<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> distance = new ArrayList<Integer>();
        Set<TreeNode> visited = new HashSet<>();
        gettingParent(root);
        distance(target, k, distance, visited);
        return distance;
    }

    public void distance(TreeNode node, int k, List<Integer> dist, Set<TreeNode> visited) {
        if (node == null || visited.contains(node) || k < 0) return;
        visited.add(node);
        if (k == 0) {
            dist.add(node.val);
            return;
        }
        distance(node.left, k-1, dist, visited);
        distance(node.right, k-1, dist, visited);
        distance(map.get(node), k-1, dist, visited);
    }

    public void gettingParent(TreeNode root) {
        if (root == null) return;

        if (root.left!=null) {
            map.put(root.left, root);
            gettingParent(root.left);
        }

        if (root.right!=null) {
            map.put(root.right, root);
            gettingParent(root.right);
        }
    }
}
