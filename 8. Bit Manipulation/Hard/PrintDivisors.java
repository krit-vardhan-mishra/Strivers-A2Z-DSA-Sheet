import java.util.ArrayList;

public class PrintDivisors {
    public static void print_divisors(int n) {
        // code here
        int k = 0;
        ArrayList<Integer> tmep = new ArrayList<>();

        for (int i=1; i*i<=n; i++) {
            if (n%i ==0) {
                tmep.add(k, i);
                if (n/i != i) tmep.add(k+1, n/i);
                k++;
            }
        }

        for (Integer integer : tmep) {
            System.out.println(integer+" ");
        }
    }
}
