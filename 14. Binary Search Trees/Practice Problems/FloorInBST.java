
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class FloorInBST {
    

    public static int floor(Node root, int x) {
        // Code here
        if (root == null) return -1;
        return floor(root, x, -1);
    }

    private static int floor(Node root, int x, int ceilValue) {
        if (root == null) return ceilValue;
        if (root.data == x) return root.data;
        if (root.data < x) ceilValue = root.data;
        if (root.data < x) return floor(root.right, x, ceilValue);
        else return floor(root.left, x, ceilValue);
    }

}

