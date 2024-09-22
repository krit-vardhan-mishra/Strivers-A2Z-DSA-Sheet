
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }

        for(int value : map) {
            if(value != 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));
    }
}
