import java.util.List;
import java.util.ArrayList;

public class ExpressionAndOperators {

    public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        funcVoid(0, num, target, "", ans, 0, 0);
        return ans;
    }

    public static void funcVoid(int index, String num, int target, String curr, List<String> ans, long prev,
            long res) {
        if (index == num.length()) {
            if (res == target) {
                ans.add(curr.toString());
            }
            return;
        }

        String str = "";
        long currNum = 0;
        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') break;

            str += num.charAt(i);
            currNum = currNum * 10 + (num.charAt(i)-'0');
            if (index == 0) {
                funcVoid(i + 1, num, target, str, ans, currNum, currNum);
            } else {
                funcVoid(i + 1, num, target, curr+"+"+str, ans, currNum, res + currNum);
                funcVoid(i + 1, num, target, curr+"-"+str, ans, -currNum, res - currNum);
                funcVoid(i + 1, num, target, curr+"*"+str, ans, prev * currNum, res - prev + (prev * currNum));
            }
        }
    }

    /*
    public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private static void dfs(String num, int target, int s, long prev, long eval, StringBuilder sb,
            List<String> ans) {
        if (s == num.length()) {
            if (eval == target)
                ans.add(sb.toString());
            return;
        }

        for (int i = s; i < num.length(); ++i) {
            if (i > s && num.charAt(s) == '0')
                return;
            final long curr = Long.parseLong(num.substring(s, i + 1));
            final int length = sb.length();
            if (s == 0) { // the first number
                dfs(num, target, i + 1, curr, curr, sb.append(curr), ans);
                sb.setLength(length);
            } else {
                dfs(num, target, i + 1, curr, eval + curr, sb.append("+").append(curr), ans);
                sb.setLength(length);
                dfs(num, target, i + 1, -curr, eval - curr, sb.append("-").append(curr), ans);
                sb.setLength(length);
                dfs(num, target, i + 1, prev * curr, eval - prev + prev * curr, sb.append("*").append(curr),
                        ans);
                sb.setLength(length);
            }
        }
    }
    */
    public static void main(String[] args) {
        System.out.println(addOperators("123", 6));
    }
}