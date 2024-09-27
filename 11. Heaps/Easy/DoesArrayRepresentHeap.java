/*
 * public boolean isMaxHeap() {
        return isMaxHeap(root);
    }

    private boolean isMaxHeap(Node root) {
        if (root == null) return true;
    
        boolean leftCheck = true;
        boolean rightCheck = true;
    
        if (root.left != null) {
            leftCheck = root.val >= root.left.val && isMaxHeap(root.left);
        }
    
        if (root.right != null) {
            rightCheck = root.val >= root.right.val && isMaxHeap(root.right);
        }
    
        return leftCheck && rightCheck;
    }
 */
public class DoesArrayRepresentHeap {
    public boolean countSub(long arr[], long n) 
    {
        // Your code goes here
        return isMaxHeap(arr, n, 0);
    }

    private boolean isMaxHeap(long arr[], long n, int i) 
    {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        boolean isLeft = true;
        boolean isRight = true;

        if (left < n) {
            if (arr[left] > arr[i]) return false;
            isLeft = isMaxHeap(arr, n, left);
        }

        if (right < n) {
            if (arr[right] > arr[i]) return false;
            isRight = isMaxHeap(arr, n, right);
        }

        return isLeft && isRight;
    }
}
