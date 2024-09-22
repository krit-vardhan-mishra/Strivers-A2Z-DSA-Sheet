public class PowerOfXToN {
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        return pow(x, n);
    }

    public static double pow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;

        double half = pow(x, n/2);
        
        if(n % 2 == 0) return half * half;
        else return half * half * x;
    }
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
    }
}
