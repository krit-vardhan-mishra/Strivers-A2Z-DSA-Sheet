import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        return backtracking(n, 0, 0, new StringBuilder(), new ArrayList<String>());
    }

    public static List<String> backtracking(int n, int open, int close, StringBuilder res, List<String> sol) {
        if(open == n && close == n) {
            sol.add(res.toString());
            return sol;
        }

        if(open < n) {
            res.append("(");
            backtracking(n, open+1, close, res, sol);
            res.deleteCharAt(res.length()-1);
        }

        if(close < open) {
            res.append(")");
            backtracking(n, open, close+1, res, sol);
            res.deleteCharAt(res.length()-1);
        }
        
        return sol;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}