
public class MinimizeMaxDistance {

    public static double distanceBetween(int[] stations, int k) {
        double start = 0, end = 1e8;
        double data = 1e-6;

        while (end - start > data) {
            double mid = start + (end - start) / 2.0;

            if(distance(stations, mid) > k) start = mid;
            else end = mid;
        } 
        return start;
    }

    private static int distance(int[] arr, double mid) {
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            count += Math.ceil((arr[i] - arr[i-1])/mid)-1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(distanceBetween(arr, 9));
    }
    
}