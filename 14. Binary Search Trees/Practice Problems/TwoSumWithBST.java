import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TwoSumWithBST {
    ArrayList<TreeNode> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left).val + list.get(right).val;
            if (sum == k) return true;
            else if (sum < k) left++;
            else right--;
        }
        return false;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
