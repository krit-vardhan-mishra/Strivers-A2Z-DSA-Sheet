
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class DeleteNode {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    public static void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode f = new ListNode(1);
        ListNode s = new ListNode(2);
        ListNode t = new ListNode(3);
        ListNode c = new ListNode(4);
        f.next = s;
        s.next = t;
        t.next = c;
        deleteNode(t);
        printNode(f);
    }
}
