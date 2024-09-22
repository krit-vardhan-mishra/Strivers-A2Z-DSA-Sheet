import java.util.ArrayList;
import java.util.List;

public class FindPrimeFactors {

    static int[] prime = new int[200001];
    public static void sieve() {
        for (int i=2; i*i<=prime.length-1; i++) {
            if (prime[i] == 0) {
                for (int j=i*i; j<=prime.length-1; j+=i) {
                    prime[j] = i;
                }
            }
        }
    }

    public static List<Integer> findPrimeFactors(int N) {
        // code here
        List<Integer> ans = new ArrayList<>();
        for (int i=2; i<=N; i++) {
            if (prime[i] == 0 && N % i == 0) {
                while (N % i == 0) {
                    ans.add(i);
                    N /= i;
                }
            }
        }
        return ans;
    }

}
