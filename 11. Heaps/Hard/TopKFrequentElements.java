import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int[] res = new int[k];
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            queue.add(new int[]{map.get(key), key});
        }


        int i = 0;
        while (!queue.isEmpty()) {
            if (k-- <= 0) break;
            res[i++] = queue.poll()[1];
        }

        return res;
    }    

    public static void main(String[] args) {
        int[] nums = {110, 1,1,-1,2, -22,35};
        int[] result = topKFrequent(nums, 2);
        for (int i : result) {
            System.out.println(i+" ");
        }
    }
}