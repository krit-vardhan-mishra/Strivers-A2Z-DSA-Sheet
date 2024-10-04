import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
public class RightSideView {
    public ArrayList<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        view(root, 0, result);
        return result;
    }
    
    public void view(TreeNode root, int level, ArrayList<Integer> result) {
        if (root == null) return;
        if (level == result.size()) result.add(root.val);
    
        view(root.right, level + 1, result);
        view(root.left, level + 1, result);
    }
    
}
