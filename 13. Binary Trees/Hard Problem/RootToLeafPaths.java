import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node (int data) {this.data = data;}
}
public class RootToLeafPaths {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        paths(root, ans, new ArrayList<>());
        return ans;
    }

    private static void paths(Node node, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp) {
        if (node == null) {
            return;
        }

        temp.add(node.data);
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(temp));
        } else {
            paths(node.left, ans, temp);
            paths(node.right, ans, temp);
        }
        temp.remove(temp.size()-1);
    }

    static void print(Node root) {
        System.out.println("┌─────────── ");
        System.out.println("│ Tree Start ");
        System.out.println("│   ");
        printl(root, "", false);
      }
    
      private static void printl(Node node, String prefix, boolean isLeft) {
        if (node != null) {
          System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
          printl(node.left, prefix + (isLeft ? "│   " : "    "), true);
          printl(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
      }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(60);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        print(a);
        System.out.println(Paths(a));
        
    }
}
