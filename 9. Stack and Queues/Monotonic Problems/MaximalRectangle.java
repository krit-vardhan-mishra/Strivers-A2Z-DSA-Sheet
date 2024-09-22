import java.util.Stack;

public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
    
        int max = 0;
        int[] stack = new int[matrix[0].length];
    
        for (char[] cs : matrix) {
            for (int i = 0; i < cs.length; i++) {
                stack[i] = (cs[i] == '1') ? stack[i] + 1 : 0;
            }
            max = Math.max(max, largestRectangleArea(stack));
        }
    
        return max;
    }
    
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
    
            result[i] = stack.isEmpty() ? arr.length : stack.peek();
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
    
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
    
        return result;
    }
    
    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };

        System.out.println(maximalRectangle(matrix));
    }
}