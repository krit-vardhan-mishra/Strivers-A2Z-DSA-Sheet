
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

public class MinMaxElement {

    static int[] minMaxValue(Node root) {
        if (root == null) return new int[]{-1, -1};

        int min = (minValue(root) == Integer.MAX_VALUE) ? -1 : minValue(root);
        int max = (maxValue(root) == Integer.MIN_VALUE) ? 1 : maxValue(root);

        return new int[]{min, max};
    } 

    // MIN_ELEMENT
    static int minValue(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.data, minValue(root.left));
    }

    // MAX_ELEMENT
    static int maxValue(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, maxValue(root.right));
    }

    public static void main(String[] args) {
        Node five = new Node(5);
        Node four = new Node(4);
        Node three = new Node(3);
        Node one = new Node(1);
        Node six = new Node(6);
        Node seven = new Node(7);

        five.left = four;
        five.right = six;
        four.left = three;
        three.left = one;
        six.right = seven;

        int[] res = minMaxValue(five);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
