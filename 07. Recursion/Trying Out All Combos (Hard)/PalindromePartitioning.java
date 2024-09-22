import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        funcVoid(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    public static void funcVoid(String s, int index, List<String> sol, List<List<String>> ans) {
        if(index >= s.length()) {
            ans.add(new ArrayList<>(sol));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                sol.add(s.substring(index, i+1));
                funcVoid(s, i+1, sol, ans);
                sol.remove(sol.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
