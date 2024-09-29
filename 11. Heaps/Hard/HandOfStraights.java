import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(map, 0)+1);
        }

        Arrays.sort(hand);
        for (int num : hand) {
            if (!map.containsKey(num)) return false;

            map.put(num, map.get(num)-1);
            if (map.get(num) <= 0) {
                map.remove(num);
            }
        }

        return true;
    }    
}