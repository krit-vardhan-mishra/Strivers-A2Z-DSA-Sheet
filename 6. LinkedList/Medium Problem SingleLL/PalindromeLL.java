
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PalindromeLL {

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) break;
        }

        ListNode temp = head;
        ListNode mid = slow;
        ListNode rev = reverseList(mid);

        while (temp != null && rev != null) {
            if(temp.val != rev.val) return false;
            temp = temp.next;
            rev = rev.next;
        }

        return true;
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
        ListNode e = new ListNode(1);
        ListNode d = new ListNode(2, e);
        ListNode c = new ListNode(2, d);
        ListNode b = new ListNode(1, c);

        printList(b);
        System.out.println(isPalindrome(b));
    }
}
