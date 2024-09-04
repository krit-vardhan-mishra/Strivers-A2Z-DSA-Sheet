import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        funcVoid(k, n, 1, new ArrayList<>(), ans);

        return ans;
    }

    public static void funcVoid(int k, int n, int index, List<Integer> sol, List<List<Integer>> ans) {
        if(k == 0 && n == 0) {
            ans.add(new ArrayList<>(sol));
            return;
        }

        if(k == 0 || n < 0) return;

        for (int i = index; i <= 9; i++) {
            sol.add(i);
            funcVoid(k-1, n-i, i+1, sol, ans);
            sol.remove(sol.size()-1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3,9));
    }
}
