class Node {
    int data;
    Node next;

    Node() {
        data = 0;
    }

    Node(int d) {
        data = d;
    }
}

public class ArrayToLinkedList {

    public static Node constructLL(int[] arr) {
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node ans = new Node();
        ans = constructLL(arr);
        printNode(ans);
    }

}