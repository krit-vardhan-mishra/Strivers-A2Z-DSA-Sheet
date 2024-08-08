public class CountGoodNumbers {

    public static int mod = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        long countEven = (n+1)/2;
        long countOdd = n/2;

        long even = pow(5, countEven);
        long odd = pow(4, countOdd);

        return (int)(even * odd % mod);
    }

    private static long pow(long x, long n) {
        if(n == 0) return 1;

        long half = pow(x, n/2);

        if(n % 2 == 0) return (half * half) % mod;
        else return (half * half * x) % mod;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
        System.out.println(countGoodNumbers(4));
        System.out.println(countGoodNumbers(50));
    }
}
