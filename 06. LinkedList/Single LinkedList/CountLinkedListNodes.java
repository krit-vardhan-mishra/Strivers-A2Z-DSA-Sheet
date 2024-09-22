class Node {
    int data;
    Node next;
    Node(int a) {data = a; next = null;}
}

public class CountLinkedListNodes {
    public static int getCount(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        Node f = new Node(1);
        Node s = new Node(2);
        Node t = new Node(3);
        Node c = new Node(4);
        f.next = s;
        s.next = t;
        t.next = c;
        System.out.println(getCount(f));
    }
}

