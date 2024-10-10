import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Node {
    int data;
    Node left, right;

    Node (int data) {this.data = data; left = right = null;}
}

public class BurningTree {

    static HashMap<Node, Node> map = new HashMap<>();
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Set<Node> visited = new HashSet<>();
        int[] timeTaken = {0};
        gettingParent(root);
        Node targetNode = gettingTarget(root, target);
        gettingTime(targetNode, timeTaken, visited);
        return timeTaken[0];
    }

    public static Node gettingTarget(Node root, int target) 
    {
        if (root == null) return null;
        if (root.data == target) return root;
        
        Node left = gettingTarget(root.left, target);
        if (left != null) return left;
        return gettingTarget(root.right, target);
    }

    public static void gettingTime(Node root, int[] timeTaken, Set<Node> visited) 
    {
        if (root == null || visited.contains(root)) return;

        visited.add(root);
        int left = calculateTime(root.left, visited);
        int right = calculateTime(root.right, visited);
        int parent = calculateTime(map.get(root), visited);

        timeTaken[0] = Math.max(timeTaken[0], Math.max(left, Math.max(right, parent)));
    }

    private static int calculateTime(Node node, Set<Node> visited) 
    {
        if (node == null || visited.contains(node)) return 0;

        visited.add(node);
        int left = calculateTime(node.left, visited);
        int right = calculateTime(node.right, visited);
        int parent = calculateTime(map.get(node), visited);

        return 1 + Math.max(left, Math.max(right, parent));
    }

    public static void gettingParent(Node root) 
    {
        if (root == null) return;

        if (root.left != null) {
            map.put(root.left, root);
            gettingParent(root.left);
        }

        if (root.right != null) {
            map.put(root.right, root);
            gettingParent(root.right);
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        five.left = seven;
        five.right = eight;
        three.right = six;
        six.right = nine;
        nine.right = ten;

        System.out.println(minTime(one, 8));
    }
}
