import java.util.HashMap;
import java.util.Map;

public class CountSubstrings {

    public static long substringCount(String s, int k) {
        int left = 0, right = 0, distinctCount = 0;
        long count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            if (freqMap.get(rightChar) == 1) {
                distinctCount++;
            }
            right++;

            while (distinctCount > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    distinctCount--;
                }
                left++;
            }

            count += right - left;
        }

        return count;
    }

    public static long substrCount(String s, int k) {
        return substringCount(s, k) - substringCount(s, k - 1);
    }

    public static void main(String[] args) {
        String str = "ecbaddce";
        System.out.println(substrCount(str, 3)); 
    }
}
