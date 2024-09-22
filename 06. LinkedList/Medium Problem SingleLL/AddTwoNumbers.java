class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;

        while (temp1 != null || temp2 != null) {
            int sum = carry;

            if(temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }
            
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        if(carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode c1 = new ListNode(3);
        ListNode b1 = new ListNode(4, c1);
        ListNode a1 = new ListNode(2, b1);
        
        ListNode c2 = new ListNode(3);
        ListNode b2 = new ListNode(4, c2);
        ListNode a2 = new ListNode(2, b2);

        ListNode ans = addTwoNumbers(a1, a2);
        while (ans != null) {
            System.out.print(ans.val+" ");
        }
    }
}
