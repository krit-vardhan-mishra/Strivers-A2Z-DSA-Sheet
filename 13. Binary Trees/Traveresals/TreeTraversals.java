import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class TreeTraversals {

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        preOrder(root, pre);
        inOrder(root, in);
        postOrder(root, post);

        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);

        return result;

    }

    private static void preOrder(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;

        ans.add(node.data);
        preOrder(node.left, ans);
        preOrder(node.right, ans);
    }

    private static void inOrder(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;

        inOrder(node.left, ans);
        ans.add(node.data);
        inOrder(node.right, ans);
    }

    private static void postOrder(TreeNode node, List<Integer> ans) { 
        if (node == null)
            return;

        postOrder(node.left, ans);
        postOrder(node.right, ans);
        ans.add(node.data);
    }

}