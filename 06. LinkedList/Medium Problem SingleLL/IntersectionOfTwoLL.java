class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class IntersectionOfTwoLL {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? headB : temp1.next;
            temp2 = (temp2 == null) ? headA : temp2.next;
        }
        
        return temp1;
    }

    public static void printList(ListNode hNode) {
        ListNode temp = hNode;

        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode c3 = new ListNode(5);
        ListNode c2 = new ListNode(4, c3);
        ListNode c1 = new ListNode(8, c2);

        ListNode a2 = new ListNode(1, c1);
        ListNode a1 = new ListNode(4, a2);

        ListNode b3 = new ListNode(1, c1);
        ListNode b2 = new ListNode(6, b3);
        ListNode b1 = new ListNode(5, b2);

        printList(a1);
        printList(b1);

        System.out.println(getIntersectionNode(a1, b1).val);
    }
}
