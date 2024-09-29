import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int max;

    public KthLargest(int k, int[] nums) {
        this.max = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < max) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}
