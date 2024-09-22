import java.util.Stack;

public class NextGreaterElementTwo {

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }

            result[i % nums.length] = stack.empty() ? -1: nums[stack.peek()];
            stack.push(i % nums.length);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1};
        int[] res = nextGreaterElements(nums);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
