class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class InsertInDLL {
    public static void addNode(Node head_ref, int pos, int data) {
        Node temp = head_ref;
        int idx = 0;

        while (idx != pos) {
            temp = temp.next;
            idx++;
        }
        
        Node newNode = new Node(data);
        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next = newNode;

        if(newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node p = new Node(2);
        Node s = new Node(4);
        Node t = new Node(5);
        Node u = new Node(4);
        p.next = s;
        s.prev = p;
        s.next = t;
        t.prev = s;
        t.next = u;
        u.prev = t;

        printNode(p);
        addNode(p, 2, 6);
        printNode(p);
    }
}
