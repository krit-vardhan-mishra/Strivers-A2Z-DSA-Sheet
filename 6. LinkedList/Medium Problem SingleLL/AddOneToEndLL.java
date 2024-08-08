class Node {
    int data;
    Node next;

    Node() {}
    Node(int data) { this.data = data; this.next = null;}
    Node(int data, Node next) {this.data = data; this.next = next;}
}

public class AddOneToEndLL {

    public static Node addOne(Node head) {

        if(head == null) return new Node(1);

        Node reversed = reverse(head);
        Node temp = reversed;
        
        while (temp != null && temp.data == 9) {
            temp.data = 0;
            temp = temp.next;
        }

        if(temp != null) {
            temp.data = temp.data + 1;
            return reverse(reversed);
        }

        return reverse(reversed);
    }

    public static Node reverse(Node head) {
        if(head == null || head.next == null) return head;

        Node newt = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newt;
    }

    public static void main(String[] args) {
        Node c = new Node(6);
        Node b = new Node(5, c);
        Node a = new Node(4, b);
        
        Node ans = addOne(a);
        while (ans != null) {
            System.out.print(ans.data+" ");
            ans = ans.next;
        }
    }
    
}
