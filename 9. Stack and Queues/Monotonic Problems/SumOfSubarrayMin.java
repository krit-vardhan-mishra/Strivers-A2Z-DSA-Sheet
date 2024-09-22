import java.util.Stack;

public class SumOfSubarrayMin {

    public static int sumSubarrayMins(int[] arr) {
        int[] nextSmall = nextSmaller(arr);
        int[] prevSmall = prevSmaller(arr);
        int mod = (int)(1e9 + 7);
        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            int first = i - prevSmall[i];
            int second = nextSmall[i] - i;
            long product = (first * second) % mod;
            product = (product * arr[i]) % mod;
            total = (total % mod + product) % mod;
        }

        return (int)total;
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
        int[] arr = {1,2,3};
        System.out.println(sumSubarrayMins(arr));
    }
}