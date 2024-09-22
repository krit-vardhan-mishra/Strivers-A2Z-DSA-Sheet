public class Node {
    int data;
    Node next;

    Node() {
        data = 0;
    }

    Node(int d) {
        data = d;
    }

    public void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }
}
