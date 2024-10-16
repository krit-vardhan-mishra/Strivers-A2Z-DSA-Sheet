public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if ((lower != null && val <= lower) || (upper != null && val >= upper))return false;
        return isValidBST(node.right, val, upper) && isValidBST(node.left, lower, val);
    }
}
