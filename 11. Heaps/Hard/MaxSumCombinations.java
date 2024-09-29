import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MaxSumCombinations {
    static List<Integer> maxCombinations(int N, int K, int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<String> visited = new HashSet<>();
        
        queue.offer(new int[]{A[N-1] + B[N-1], N-1, N-1});
        visited.add((N-1) + "," + (N-1));

        while (K-- > 0 && !queue.isEmpty()) {
            int[] curr = queue.poll();
            result.add(curr[0]);

            int i = curr[1];
            int j = curr[2];

            if (i - 1 >= 0 && !visited.contains((i-1)+ "," + j)) {
                queue.offer(new int[]{A[i-1] + B[j], i-1, j});
                visited.add((i-1) + "," + j);
            }

            if (j - 1 >= 0 && !visited.contains(i+ "," + (j-1))) {
                queue.offer(new int[]{A[i] + B[j-1], i, j-1});
                visited.add(i + "," + (j-1));
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] A = {3,2};
        int[] B = {1,4};
        System.out.println(maxCombinations(A.length, 2, A, B));
    }
}
