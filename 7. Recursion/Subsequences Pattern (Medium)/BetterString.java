import java.util.HashMap;
import java.util.Map;

public class BetterString {
    public static String betterString(String str1, String str2) {
        if(str1.length() == 1) return str1;
        int s1 = helper(str1);
        int s2 = helper(str2);

        return s2>s1 ? str2 : str1;
    }

    public static int helper(String p) {
        Map<Character, Integer> map = new HashMap<>();

        int n = p.length();
        int[] up = new int[n+1];

        up[0] = 1;
        for (int i = 1; i <= n; i++) {
            up[i] = 2 * up[i-1];

            if(map.containsKey(p.charAt(i-1))) {
                up[i] = up[i] - up[map.get(p.charAt(i-1))];
            }
            
            map.put(p.charAt(i-1),(i-1));
        }

        return up[n];
    }

    public static void main(String[] args) {
        System.out.println(betterString("gfg","ggg"));
        System.out.println(betterString("a","b"));
    }
    
}
