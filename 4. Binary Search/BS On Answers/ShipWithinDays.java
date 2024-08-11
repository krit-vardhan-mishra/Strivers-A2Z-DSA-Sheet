public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0, end = 0;
        for (int i : weights) {
            if(i > start) start = i;
            end += i;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(findDays(weights, mid) <= days) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    public int findDays(int[] weights, int mid) {
        int days = 1, load = 0;

        for (int i = 0; i < weights.length; i++) {
            if(load + weights[i] > mid) {
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }

        return days;
    }
}
