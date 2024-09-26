public class LongestRepeatingCharReplacement {
    public static int characterReplacement(String s, int k) {
        int j = 0;
        int max = 0;
        char[] ans = s.toCharArray();
        int[] count = new int[26];
        
        for (int i = 0; i < ans.length; i++) {
            count[ans[i]-'A']++;

            max = Math.max(max,count[ans[i]-'A']);

            while (i - j + 1 - max > k) {
                count[ans[j++]-'A']--;
            }
        }

        return ans.length - j;
    }
    

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
