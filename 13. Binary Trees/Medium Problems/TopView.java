import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left;
    Node right;

    Node (int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TopView {

    static class Pair {
        int h;
        Node node;

        Pair (int h, Node node) {
            this.h = h;
            this.node = node;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();
            int h = curr.h;
            Node temp = curr.node;

            if (!map.containsKey(h)) map.put(h, temp.data);
            if (temp.left != null) {
                queue.add(new Pair(curr.h-1, temp.left));
            }
            if (temp.right != null) {
                queue.add(new Pair(curr.h+1, temp.right));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
}
