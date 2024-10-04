class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) && (p.right == q.right) && (p.left == q.left);
    }
}
