public class SumOfFirstNRec {
    public static long sumOfSeries(long n) {
        if(n == 0) return 0;
        return n*n*n + sumOfSeries(n-1);
    }
    public static void main(String[] args) {
        long res = sumOfSeries(5);
        System.out.println(res);
    }
}
