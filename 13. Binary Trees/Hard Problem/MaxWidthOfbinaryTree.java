import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode (int val) {this.val = val;}
    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MaxWidthOfbinaryTree {

    private void width(TreeNode node, int index, int level, ArrayList<Integer> temp, int[] ans) {
        if (node == null) return ;
        if (temp.size() == level) {
            temp.add(index);
        }
        
        ans[0] = Math.max(ans[0], index - temp.get(level) + 1);
        width(node.left, index * 2, level+1, temp, ans);
        width(node.right, index*2+1, level+1, temp, ans);
    }

    public int widthOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        width(root, 1, 0, new ArrayList<>(), res);
        return res[0];
    }
}
