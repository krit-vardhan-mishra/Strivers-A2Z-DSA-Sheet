
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

public class CeilInBST {

    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        return findCeil(root, key, -1);
    }

    private int findCeil(Node root, int key, int ceilValue) {
        if (root == null) return ceilValue;
        if (root.data == key) return root.data;
        if (root.data > key) ceilValue = root.data;
        if (root.data > key) return findCeil(root.left, key, ceilValue);
        else return findCeil(root.right, key, ceilValue);
    }

}
