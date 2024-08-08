class Node {
    int data;
    Node next;
    Node bottom;

    Node (int x) {
        data = x;
        next = null;
        bottom = null;
    }
}

public class FlatteningLL {

    /* // This one is for making Sub-Array LinkedList into Singly Linked List without sorting
    public static Node flatten(Node root) {
        if(root == null) return root;

        Node dummy = new Node(0);
        Node temp = dummy;
        Node head = root;

        while (head != null) {
            Node bottomTemp = head;
            while (bottomTemp != null) {
                temp.bottom = bottomTemp;
                temp = temp.bottom;
                bottomTemp = bottomTemp.bottom;
            }
            head = head.next;
        }

        return dummy.bottom;
    }
     */

    public static Node flatten(Node root) {
        if(root == null || root.next == null) return root;

        Node mergeH = flatten(root.next);
        root = mergeSort(root, mergeH);

        return root;
    }

    static Node mergeSort(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node res = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        if(list1 != null) res.bottom = list1;
        else res.bottom = list2;

        if(dummy.bottom != null) dummy.bottom.next = null;

        return dummy.bottom;
    }

    /* // Printing Sub-Array Linked List with recursion
    public static void printList(Node head, int depth) {
        Node temp = head;
        while (temp != null) {
            System.err.print(temp.data);
          
            if(temp.bottom != null) {
                System.out.print(" -> ");
                printList(temp.bottom, depth+1);
            }
            if(head.next != null) {
                System.out.println();
                for(int i=0; i<depth; i++) {
                    System.err.println("| ");
                }
            }
            temp = temp.next;
        }
    }
    */

    // Printing Sub-Array Linked List with Loop.
    public static void printList(Node head) {
        Node temp = head;
    
        while (temp != null) {
            Node bottomTemp = temp;
            while (bottomTemp != null) {
                System.out.print(bottomTemp.data);
                if(bottomTemp.bottom != null) {
                    System.out.print(" -> ");
                }
                bottomTemp = bottomTemp.bottom;
            }
            System.out.println();
            temp = temp.next;
        }
        System.out.println();
    }
    

    public static void printListFlatten(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            if(temp.bottom != null) {
                System.out.print(" -> ");
            }
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(10);
        Node c = new Node(19);
        Node d = new Node(28);
        Node e = new Node(7);
        Node f = new Node(8);
        Node g = new Node(30);
        Node h = new Node(20);
        Node i = new Node(22);
        Node j = new Node(50);
        Node k = new Node(35);
        Node l = new Node(40);
        Node m = new Node(45);

        a.next = b;
        b.next = c;
        c.next = d;

        a.bottom = e;
        e.bottom = f;
        f.bottom = g;

        b.bottom = h;

        c.bottom = i;
        i.bottom = j;

        d.bottom = k;
        k.bottom = l;
        l.bottom = m;

        printList(a);

        Node res = flatten(a);

        printListFlatten(res);
    }
    
}