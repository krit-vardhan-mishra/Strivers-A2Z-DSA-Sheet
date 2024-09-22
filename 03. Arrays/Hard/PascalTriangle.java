import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansMatrix = new ArrayList<>();
        
        for(int i=1;i<=numRows;i++) {
            ansMatrix.add(genRow(i));
        }
        
        return ansMatrix;
    }
    
    public static List<Integer> genRow(int r) {
        long res = 1;
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        
        for(int i=1;i<r;i++) {
            res = res * (r-i);
            res = res / i;
            ans.add((int)res);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
