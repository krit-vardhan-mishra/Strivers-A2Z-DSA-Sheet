class Node {
    int data;
    Node next;

    Node(int d) {data = d; next = null;}
}

public class InsertAtEnd {
    public static Node insertAtEnd(Node head, int x) {
        if(head == null) return new Node(x);
        Node temp = head;
        Node newNode = new Node(x);

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node f = new Node(1);
        Node s = new Node(2);
        Node t = new Node(3);
        Node c = new Node(4);
        f.next = s;
        s.next = t;
        t.next = c;
        Node head = insertAtEnd(f, 5);
        printNode(head);
    }
}
