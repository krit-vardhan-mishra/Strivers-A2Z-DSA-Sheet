import java.util.ArrayList;

class Node {
    int data;
    Node next;
    Node prev;

    Node (int data) {
        this.data = data;
        next = prev = null;
    } 
}

public class FindPairsWithGivenSum {

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node tail = head;
        Node temp = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        while (temp.data < tail.data) {
            int sum = temp.data + tail.data;
            if(sum == target) {
                ArrayList<Integer> preq = new ArrayList<>();
                preq.add(temp.data);
                preq.add(tail.data);
                ans.add(preq);
                temp = temp.next;
                tail = tail.prev;
            } else if(sum < target) {
                temp = temp.next;
            } else {
                tail = tail.prev;
            }
        }

        return ans;
    }

    public static void printNode(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(8);
        Node g = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        g.prev = f;
        f.prev = e;
        e.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;

        printNode(a);
        ArrayList<ArrayList<Integer>> res = findPairsWithGivenSum(7, a);
        System.out.println(res);
    }
}
