import java.util.HashMap;

public class LongestConsecutiveSeqInArray {

    public static int longestSuccessiveElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int num : arr) {
            map.put(num, 1);
        }
        
        for (int num : arr) {
            if(map.containsKey(num+1)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 1, 3, 2, 4};
        System.out.println(longestSuccessiveElements(arr));
    }
}
