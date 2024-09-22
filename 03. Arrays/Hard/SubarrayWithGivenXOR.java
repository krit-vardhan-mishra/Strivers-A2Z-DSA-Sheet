import java.util.HashMap;

public class SubarrayWithGivenXOR {

    public static int solve(int[] arr, int a) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int XOR = 0, count = 0;
        map.put(XOR, 1);

        for(int i=0; i < arr.length; i++) {
            XOR ^= arr[i];
            int c = XOR ^ a;

            if(map.containsKey(c)) count += map.get(c);
            if(map.containsKey(XOR)) map.put(XOR, map.get(XOR)+1);
            else map.put(XOR, 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        System.out.println(solve(arr, 6));
    }
}
