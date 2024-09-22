
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LinkedListCycleDetect {

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) return true;
        }

        return false;
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
        ListNode e = new ListNode(-4);
        ListNode d = new ListNode(0, e);
        ListNode c = new ListNode(2, d);
        ListNode b = new ListNode(3, c);

        printList(b);
        System.out.println(hasCycle(b));

    }
}
