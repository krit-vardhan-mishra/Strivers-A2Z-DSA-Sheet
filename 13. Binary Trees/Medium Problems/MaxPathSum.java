public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        pathSum(root, max);
        return max[0];
    }

    private int pathSum(TreeNode root, int[] max) {
        if (root == null) return 0;

        int left = Math.max(0, pathSum(root.left, max));
        int right = Math.max(0, pathSum(root.right, max));

        max[0] = Math.max(max[0], left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
