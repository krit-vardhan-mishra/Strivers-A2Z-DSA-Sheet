import java.util.Stack;

public class NearestSmallerElement {
    public static int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();

            stack.push(A[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        int[] result = prevSmaller(arr);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
