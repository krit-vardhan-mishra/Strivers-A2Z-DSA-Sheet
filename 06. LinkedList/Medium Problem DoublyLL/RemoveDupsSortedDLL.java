class Node {
    int data;
    Node next;
    Node prev;

    Node (int data) {
        this.data = data;
        next = prev = null;
    } 
}

public class RemoveDupsSortedDLL {

    public static Node removeDuplicates(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;

        while (temp != null && temp.next != null) {
            if(temp.data == temp.next.data) {
                temp.next = temp.next.next;
                if(temp.next != null) {
                    temp.next.prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

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
        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(1);
        Node d = new Node(2);
        Node e = new Node(3);
        Node f = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        f.prev = e;
        e.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;

        printNode(a);
        Node res = removeDuplicates(a);
        printNode(res);
    }
}
