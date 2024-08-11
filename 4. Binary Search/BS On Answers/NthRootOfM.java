public class NthRootOfM {
    public static int NthRoot(int n, int m) {
        long start = 1, end = m;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long val = 1;
            boolean overflow = false;

            for (int i = 1; i <= n; i++) {
                val *= mid;
                if(val > m) {
                    overflow = true;
                    break;
                }
            }
            if(!overflow && val == m) return (int)mid;
            else if(!overflow && val < m) start = mid + 1;
            else end = mid - 1; 
        }

        return -1;
    }
}
