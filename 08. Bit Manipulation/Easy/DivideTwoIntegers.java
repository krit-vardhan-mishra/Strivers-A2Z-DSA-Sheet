public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {

        long quotient = 0;
        int sign = ((dividend < 0) != (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        while (dvd >= dvs) {
            int count = 0;

            while (dvd >= (dvs << (count+1))) {
                count++;
            }
            quotient += 1L << count;
            dvd -= dvs << count;
        }

        if (quotient >= Integer.MIN_VALUE && quotient <= Integer.MAX_VALUE) return sign * (int)quotient;

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
    }
}
