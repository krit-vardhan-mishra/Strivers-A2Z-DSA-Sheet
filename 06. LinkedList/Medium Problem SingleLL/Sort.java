
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class Sort {

    // public static ListNode sortList(ListNode head) {
    //     return quickSort(head, null);
    // }

    // public static ListNode quickSort(ListNode head, ListNode tail) {
    //     if (head == null || head.next == null || head == tail) {
    //         return head;
    //     }
    //     boolean sorted = true;
    //     ListNode pivot = head, prev = head, curr = head.next;
    //     while (curr != null && curr != tail) {
    //         ListNode next = curr.next;
    //         if (curr.val < pivot.val) {
    //             sorted = false;
    //             curr.next = head;
    //             head = curr;
    //             prev.next = next;
    //         } else {
    //             if (curr.val < prev.val) {
    //                 sorted = false;
    //             }
    //             prev = curr;
    //         }
    //         curr = next;
    //     }
    //     if (sorted) {
    //         return head;
    //     }
    //     pivot.next = quickSort(pivot.next, tail);
    //     return quickSort(head, pivot);
    // }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(leftHead);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    private static ListNode getMiddle(ListNode head) {
        if(head == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode ans = new ListNode();
        ListNode dummy = ans;

        while (left != null && right != null) {
            if(left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }

        dummy.next = left != null ? left : right;
        return ans.next;
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
        ListNode a1 = sortList(a);
        printList(a1);
    }
}
