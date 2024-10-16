
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

public class RecoverBST {

    private TreeNode prev = null;
    private TreeNode left = null;
    private TreeNode right = null;

    public void recoverTree(TreeNode node) {
        inorder(node);
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && node.val < prev.val) {
            right = node;
            if (left == null) left = prev;
            else return;
        }
        prev = node;
        inorder(node.right);
    }
}
