public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return symmetric(root1.right, root2.left) && symmetric(root1.left, root2.right);
    }

}
