public class KokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = (int)1e9;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int totalHrs = 0;

            for (int pile : piles) {
                totalHrs += (pile + mid - 1) / mid;
            }

            if(totalHrs <= h) end = mid;
            else start = mid + 1;
        }

        return start;
    }
}
