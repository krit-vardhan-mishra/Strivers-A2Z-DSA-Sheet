class Node {
    int data;
    Node next;
    Node prev;

    Node (int data) {
        this.data = data;
        next = prev = null;
    } 
}

public class DeleteAllOccOfKeyInDLL {

    public static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;

        while (temp != null) {
            if(temp.data == x) {
                if(temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
                if(temp.next != null) {
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public static void printNode(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(2);
        Node c = new Node(10);
        Node d = new Node(8);
        Node e = new Node(4);
        Node f = new Node(2);
        Node g = new Node(5);
        Node h = new Node(2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        h.prev = g;
        g.prev = f;
        f.prev = e;
        e.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;

        printNode(a);
        Node res = deleteAllOccurOfX(a, 2);
        printNode(res);
    }
}
