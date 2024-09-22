import java.util.Stack;

public class LargestHistogram {

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] prev = prevSmaller(heights);
        int[] next = nextSmaller(heights);

        for (int i = 0; i < heights.length; i++) {
            int curr = (next[i] - prev[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, curr);
        }

        return maxArea;
    }

    public static int[] nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) result[i] = arr.length;
            else result[i] = stack.peek();

            stack.push(i);
        }

        return result;
    }

    public static int[] prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
