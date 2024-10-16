import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplication {
    int minimumMultiplicaton(int[] arr, int start, int end) {
        // Your code here
        int[] ans = new int[100001];
        Arrays.fill(ans, -1);
        int mod = 100000;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start % mod);
        ans[start] = 0;

        while (!queue.isEmpty()) {
            int top = queue.poll();

            if (top == end) {
                return ans[end];
            }

            for (int i=0; i<arr.length; i++) {
                int temp = top * arr[i];
                temp = temp % mod;

                if (ans[temp] == -1) {
                    ans[temp] = ans[top] + 1;
                    queue.add(temp);
                }
            }
        }
        return -1;
    }
}
