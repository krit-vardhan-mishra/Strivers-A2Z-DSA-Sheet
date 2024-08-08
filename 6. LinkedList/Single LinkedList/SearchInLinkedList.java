class Node {
    int data;
    Node next;

    Node(int d) {data = d; next = null;}
}

public class SearchInLinkedList {
    public static boolean searchKey(int n, Node head, int key) {
        while (head != null) {
            if(head.data == key) return true;
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node f = new Node(1);
        Node s = new Node(2);
        Node t = new Node(3);
        Node c = new Node(4);
        f.next = s;
        s.next = t;
        t.next = c;
        System.out.println(searchKey(4, f, 3));
    }
}
