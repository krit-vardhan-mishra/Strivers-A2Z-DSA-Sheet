class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class ReverseListK {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode temp1 = head;
        int len = 0;
        while (temp1 != null) {
            len++;
            temp1 = temp1.next;
        }

        k = k % len;
        if(k == 0) return head;
        int rot = len - k;

        ListNode temp2 = head;
        for(int i = 0; i < rot-1; i++) {
            temp2 = temp2.next;
        }

        ListNode newHead = temp2.next;
        temp2.next = null;

        ListNode temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return newHead;
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
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        printList(a);
        ListNode res = rotateRight(a, 2);
        printList(res);
    }
}
