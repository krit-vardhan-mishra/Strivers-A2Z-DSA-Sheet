import java.util.ArrayList;

class Node {
    int val;
    Node left, right;

    Node(int val) {this.val = val; left = null; right = null;}
}

public class BinaryTreeRepresentation {
    public static void createTree(Node root0, ArrayList<Integer> v) {
        root0.left = new Node(v.get(1));
        root0.right = new Node(v.get(2));
        root0.left.left = new Node(v.get(3));
        root0.left.right = new Node(v.get(4));
        root0.right.left = new Node(v.get(5));
        root0.right.right = new Node(v.get(6));
    }

}
