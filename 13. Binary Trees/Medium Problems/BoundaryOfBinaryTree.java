import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BoundaryOfBinaryTree {
    public static ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        if (!isLeaf(node)) result.add(node.data);

        leftBoundary(node, result);
        leafBoundary(node, result);
        rightBoundary(node, result);

        return result;
    }

    private static void leftBoundary(Node node, ArrayList<Integer> result) {
        Node curr = node.left;
        while (curr != null) {
            if(!isLeaf(curr)) result.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    private static void rightBoundary(Node node, ArrayList<Integer> result) {
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for (int i = temp.size()-1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    private static void leafBoundary(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        if(isLeaf(node)) {
            result.add(node.data);
        }
        else {
            leafBoundary(node.left, result);
            leafBoundary(node.right, result);
        }
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static void main(String args[]) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);

        a.left = b;
        b.left = d;
        b.right = e;
        a.right = c;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;

        System.out.println(boundary(a));
    }
}