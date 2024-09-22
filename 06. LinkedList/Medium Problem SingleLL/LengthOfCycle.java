class Node {
    int data;
    Node next;
    
    Node (int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node (int data) {
        this.data = data;
        this.next = null;
    }
}

public class LengthOfCycle {
    public static int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                int length = 0;
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                return length;
            }
        }

        return 0;
    }
}
