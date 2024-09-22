class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class DeleteNthEndNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        
        ListNode temp = head;
        int len = 1;
        while (temp != null && temp.next != null) {
            temp = temp.next;
            len++;
        }

        int pos = len - n;
        ListNode temp2 = head;

        if(pos == 0) {
            return head.next;
        }

        for(int i=0;i<pos-1;i++) {
            temp2 = temp2.next;
        }

        if(temp2.next.next != null) {
            temp2.next = temp2.next.next;
        } else {
            temp2.next = null;
        }

        return head;
    }

    // public static ListNode removeNthFromEnd(ListNode head, int n) {
    //     if (head == null || head.next == null) return null;
    
    //     ListNode dummy = new ListNode(0);
    //     dummy.next = head;
    //     ListNode fast = dummy, slow = dummy;
    
    //     for (int i = 0; i <= n; i++) {
    //         fast = fast.next;
    //     }
        
    //     while (fast != null) {
    //         fast = fast.next;
    //         slow = slow.next;
    //     }
    
    //     slow.next = slow.next.next;
    //     return dummy.next;
    // }    

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
        ListNode head = removeNthFromEnd(a, 2);
        printList(head);
    }

}
