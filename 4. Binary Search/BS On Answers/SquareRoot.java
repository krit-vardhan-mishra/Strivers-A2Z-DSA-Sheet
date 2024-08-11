public class SquareRoot {
    static long floorSqrt(long n) {
        if(n < 2) return n;

        long start = 1, end = n;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long val = mid * mid;

            if(val == n) return mid;
            else if(val <= n) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }
}
