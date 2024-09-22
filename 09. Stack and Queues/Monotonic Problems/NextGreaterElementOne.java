import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementOne {

    public static int[] nextGreaterElements(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,1,2}, arr2 = {1,3,4,2};
        int[] res = nextGreaterElements(arr1, arr2);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
