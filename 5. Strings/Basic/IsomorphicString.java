import java.util.HashMap;

public class IsomorphicString {
    public static boolean isIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char s = s1.charAt(i);
            char t = s2.charAt(i);

            if((map.containsKey(s) && map.get(s) != t) || (!map.containsKey(s) && map.values().contains(t))) return false;
            
            map.put(s, t);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
    }
}
