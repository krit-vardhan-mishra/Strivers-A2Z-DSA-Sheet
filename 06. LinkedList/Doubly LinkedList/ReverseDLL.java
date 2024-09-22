class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.next = next;
        this.prev = null;
    }
}

public class ReverseDLL {

    public static Node reverseDLL(Node head) {
        if(head == null) return head;

        Node curr = head;
        Node temp = null;


        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if(temp != null) head = temp.prev;

        return head;
    }

    public static void printNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node p = new Node(3);
        Node s = new Node(4);
        Node t = new Node(5);
        p.next = s;
        s.prev = p;
        s.next = t;
        t.prev = s;

        printNode(p);
        p = reverseDLL(p);
        printNode(p);
    }
}
