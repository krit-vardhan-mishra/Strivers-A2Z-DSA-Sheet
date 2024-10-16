public class KthSmallestInBST {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return smallest(root, k).val;
    }
    public TreeNode smallest(TreeNode root, int k) {
        if (root == null) return null;

        TreeNode left = smallest(root.left, k);

        if (left != null) return left;
        count++;
        if (count == k) return root;
        return smallest(root.right, k);
    }
}
