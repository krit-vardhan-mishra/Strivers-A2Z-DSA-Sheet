import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class LetterCombinationPhoneNumber {

    // Optimized
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<String>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> combinations = new ArrayList<>();
        permutation(combinations, digits, "", map);
        return combinations;
    }

    public static void permutation(List<String> ans, String str, String p, Map<Character, String> map) {
        if (str.isEmpty()) {
            ans.add(p);
            return;
        }
        char ch = str.charAt(0);
        String letters = map.get(ch);
        if (letters == null)
            return;
        for (char letter : letters.toCharArray()) {
            permutation(ans, str.substring(1), p + letter, map);
        }
    }

    public static void main(String[] args) {
        String s = "23";
        System.out.println(letterCombinations(s));
    }

}