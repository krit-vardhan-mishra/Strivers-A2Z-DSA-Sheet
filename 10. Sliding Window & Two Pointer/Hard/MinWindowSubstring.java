import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()) return "";
        if (s.equals(t)) return s;

        String res = "";
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0)+1);
        }

        int i = 0, j = 0, length = Integer.MAX_VALUE;
        int req = tmap.size();
        int form = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            smap.put(c, smap.getOrDefault(c, 0)+1);

            if (tmap.containsKey(c) && smap.get(c).equals(tmap.get(c))) {
                form++;
            }

            while (i <= j && form == req) {
                char ch = s.charAt(i);

                if (j-i+1 < length) {
                    length = j - i + 1;
                    res = s.substring(i, j+1);
                }

                smap.put(ch, smap.get(ch)-1);
                if (tmap.containsKey(ch) && smap.get(ch) < tmap.get(ch)) {
                    form--;
                }

                i++;
            }
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
