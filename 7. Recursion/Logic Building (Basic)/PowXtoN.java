public class PowXtoN {
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            x = 1/x;
            n = -n;
            
        }
        return pow(x, n);
    }

    public static double pow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;

        double half = pow(x, n/2);
        
        if(n % 2 == 0) return half * half;
        else return half*half*x;
    }

    public static void main(String[] args) {
        double d1 = 2.00000;
        double d2 = 2.10000;
        double d3 = 2.00000;
        int n1 = 10;
        int n2 = 3;
        int n3 = -2;

        System.out.println(myPow(d1, n1));        
        System.out.println(myPow(d2, n2));
        System.out.println(myPow(d3, n3));

    }
}
