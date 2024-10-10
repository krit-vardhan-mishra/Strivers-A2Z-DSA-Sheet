
class Node {
    int data;
    Node left, right;

    Node (int key) {data = key;}
}

public class ChildrenSum {
    public static int isSumProperty(Node root) {
        return isSum(root) ? 1 : 0;
    }

    private static boolean isSum(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int leftData = (root.left != null) ? root.left.data : 0;
        int rightData = (root.right != null) ? root.right.data : 0;

        int sum = leftData + rightData;
        if (sum != root.data) return false;

        return isSum(root.left) && isSum(root.right);
    }
}
