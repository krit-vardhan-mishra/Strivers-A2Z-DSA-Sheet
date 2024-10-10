import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MorrisTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inOrder(root, result);

        return result;
    }

    private void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }
}
