
public class LongestHappyPrefix {
    
    public static String longestPrefix(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        
        for (int i = 1; i < n; i++) {
            int j = prefix[i-1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefix[j-1];
            }
            if (s.charAt(i) == s.charAt(j)) j++;
            prefix[i] = j;
        }

        return s.substring(0, prefix[n-1]);
    }    

    public static void main(String[] args) {
        System.out.println(longestPrefix("level"));
        System.out.println("ababab");
    }
}
