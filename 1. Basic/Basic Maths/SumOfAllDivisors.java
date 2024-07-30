public class SumOfAllDivisors {
    public static long sumOfDivisors(int n) {
        if(n < 1) return 0;

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i*(n/i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDivisors(4));
        System.out.println(sumOfDivisors(5));
    }
}
