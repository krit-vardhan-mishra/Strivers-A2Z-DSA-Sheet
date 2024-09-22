

public class SumOfBeauty {
    
    public static int beautySum(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j)-'a']++;
                count += beauty(freq);
            }
        }

        return count;
    }

    public static int beauty(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if(i > 0) {
                min = Math.min(i, min);
                max = Math.max(i, max);
            }
        }

        return max - min;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }
}
