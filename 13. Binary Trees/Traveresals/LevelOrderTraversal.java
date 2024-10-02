import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                TreeNode tempNode = queue.poll();
                temp.add(tempNode.val);    
                
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            
            result.add(temp);
        }

        return result;
    }

    // public static List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (root == null) return result;
    //     levelOrderTraversal(root, result, 0);
    //     return result;
    // }

    // public static void levelOrderTraversal(TreeNode root, List<List<Integer>> result, int level) {
    //     if (root == null) return;

    //     if (result.size() == level) {
    //         result.add(new ArrayList<>());
    //     }

    //     result.get(level).add(root.val);

    //     levelOrderTraversal(root.left, result, level + 1);
    //     levelOrderTraversal(root.right, result, level + 1);
    // }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        System.out.println(levelOrder(a));
    }
}

