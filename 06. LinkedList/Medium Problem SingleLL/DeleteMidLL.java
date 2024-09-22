class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class DeleteMidLL {

    public static ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        prevSlow.next = slow.next;

        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode g = new ListNode(6);
        ListNode f = new ListNode(2, g);
        ListNode e = new ListNode(1, f);
        ListNode d = new ListNode(7, e);
        ListNode c = new ListNode(4, d);
        ListNode b = new ListNode(3, c);
        ListNode a = new ListNode(1, b);

        printList(a);
        ListNode newt = deleteMiddle(a);
        printList(newt);
    }
}
