import java.util.ArrayList;

public class PrimeFactors {
    public int[] AllPrimeFactors(int N) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i=2; i*i<=N; i++) {
            if (N%i ==0) temp.add(i);
            while (N % i == 0) N /= i;
        }
        if (N != 1) temp.add(N);
        
        int[] ans = new int[temp.size()];
        int k = 0;
        for (int i : temp) {
            ans[k++] = i;
        }

        return ans;
    }    
}
