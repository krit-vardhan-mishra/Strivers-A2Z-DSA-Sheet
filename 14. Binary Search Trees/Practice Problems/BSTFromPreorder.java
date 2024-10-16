
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
        val = item;
        left = right = null;
    }

    TreeNode() {}
}

public class BSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > root.val) {
                root.right = insertNode(root.right, preorder[i]);;
            } else {
                root.left = insertNode(root.left, preorder[i]);
            }
        }

        return root;
    }

    public TreeNode insertNode(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertNode(root.left, val);
        else root.right = insertNode(root.right, val);
        return root;
    }
}
