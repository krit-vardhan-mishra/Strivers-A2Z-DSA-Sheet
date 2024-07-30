import java.util.ArrayList;

public class FindAllFact {
    public static ArrayList<Long> factorialNumbers(long n) {
        return helper(n, 1, 1, new ArrayList<Long>());
    }

    private static ArrayList<Long> helper(long n, long val, long m, ArrayList<Long> arr) {
        if(m > n) return arr;

        arr.add(m);
        return helper(n, val+1, m*(val+1), arr);
    }

    public static void main(String[] args) {
        ArrayList<Long> ans = factorialNumbers(6);
        System.out.println(ans);
    }
}
