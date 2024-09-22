class Node {
    int data;
    Node next;
    
    Node() {}
    Node(int data) {this.data = data; this.next = null;}
    Node(int data, Node next) {this.data = data; this.next = next;}
}

public class SortColorLL {
    
    public static Node segregate(Node head) {
        if(head == null || head.next == null) return head;

        Node zeroHead = new Node(0);
        Node oneHead = new Node(0);
        Node twoHead = new Node(0);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;

        while (temp != null) {
            if(temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if(temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        two.next = null;

        if(oneHead.next != null) zero.next = oneHead.next;
        else zero.next = twoHead.next;

        one.next = twoHead.next;
        
        return zeroHead.next;
    }

    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node h = new Node(2);
        Node g = new Node(2, h);
        Node f = new Node(0, g);
        Node e = new Node(2, f);
        Node d = new Node(1, e);
        Node c = new Node(2, d);
        Node b = new Node(2, c);
        Node a = new Node(1, b);

        printList(a);
        Node newt = segregate(a);
        printList(newt);
    }
    
}