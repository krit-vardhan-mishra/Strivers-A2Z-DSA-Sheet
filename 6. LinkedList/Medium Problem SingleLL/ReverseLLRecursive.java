
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLLRecursive {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        printList(a);
        ListNode newNode = reverseList(a);
        printList(newNode);
    }
}
