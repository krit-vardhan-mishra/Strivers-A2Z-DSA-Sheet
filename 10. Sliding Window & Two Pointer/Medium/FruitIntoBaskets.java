import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    // 3
    public static int totalFruits(Integer[] arr) {
        if (arr.length <= 2) return arr.length;
        
        int i = 0, j = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int k = 2;

        while(i < arr.length) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            
            while (map.size() > k) {
                map.put(arr[j], map.getOrDefault(arr[j], 0)-1);
                if (map.get(arr[j]) <= 0) {
                    map.remove(arr[j]);
                }
                j++;
            }
            
            max = Math.max(max, i-j+1);
            i++;
        }
      
        return max;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,1,2,2,2,2};
        System.out.println(totalFruits(arr));
    }
}
