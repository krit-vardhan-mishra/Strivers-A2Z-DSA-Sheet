class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class ArrayToDoublyLL {
    public static Node constructDLL(int arr[]) {
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
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
        Node ans = constructDLL(arr);
        printNode(ans);
    }
}
