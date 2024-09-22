public class LCMAndGCD {
    public static Long[] lcmAndGcd(Long A, Long B) {
        Long gcd = gcd(A, B);
        Long lcm = (A * B) / gcd;
        return new Long[]{lcm, gcd};
    }

    private static Long gcd(Long a, Long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        Long[] ans1 = lcmAndGcd(5L, 10L);
        Long[] ans2 = lcmAndGcd(14L, 8L);
            System.out.println(ans1[0]+" "+ans1[1]);
            System.out.println(ans2[0]+" "+ans2[1]);
    }
}
