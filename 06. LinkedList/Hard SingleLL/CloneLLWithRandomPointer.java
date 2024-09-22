class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CloneLLWithRandomPointer {

    public static Node clone(Node head) {
        if(head == null) {
            return head;
        }

        Node temp = head;
        while (temp != null) {
            Node curr = new Node(temp.val);
            curr.next = temp.next;
            temp.next = curr;
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            Node curr = temp.next;
            if(temp.random != null) {
                curr.random = temp.random.next;
            } else {
                curr.random = null;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node dummy = new Node(-1);
        Node ans = dummy;

        while (temp != null) {
            ans.next = temp.next;
            ans = ans.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void printL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print("Data : "+temp.val);
            if(temp.random != null) {
                System.out.print(", Random : "+temp.random.val);
            } else {
                System.out.print(", Random : null");
            }
            System.out.println();
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        printL(a);
        printL(clone(a));
    }
}
