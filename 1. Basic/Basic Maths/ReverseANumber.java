public class ReverseANumber {
    public static int reverse(int n) {
        int res = 0;
        while (n != 0) {
            int ld = n % 10;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = (res * 10)+ld;
            n /= 10;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
}
