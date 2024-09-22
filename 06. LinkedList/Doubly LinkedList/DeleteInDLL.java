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

public class DeleteInDLL {

    public static Node deleteNode(Node head, int x) {

        Node temp = head;
        int idx = 1;

        if (x == 1) {
            Node front = head.next;
            head.next = null;
            front.prev = null;
            return front;
        }

        while (idx < x - 1 && temp != null) {
            temp = temp.next;
            idx++;
        }

        if(temp != null && temp.next != null) {
            Node del = temp.next;
            temp.next = del.next;

            if(del.next != null) del.next.prev = temp;
        }
        
        return head;
    }

    public static void printNode(Node head) {
        Node temp = head;

        while (temp != null) {
            System.err.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node p = new Node(2);
    Node s = new Node(4);
    Node t = new Node(5);
    p.next = s;
    s.prev = p;
    s.next = t;
    t.prev = s;

    printNode(p);
    p = deleteNode(p, 2);
    printNode(p);
    }
}
