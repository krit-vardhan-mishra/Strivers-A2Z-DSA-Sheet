import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peekFirst() < i - k + 1) {
                stack.pollFirst();
            }

            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                stack.pollLast();
            }

            stack.offerLast(i);
            System.out.println(stack);
            if (i >= k - 1) {
                res[i - k + 1] = nums[stack.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}