public class CeilTheFloor {

    public static int[] getFloorAndCeil(int x, int[] arr) {
        int floor = -1;
        int ceil = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= x) {
                if(floor == -1 || arr[i] > floor) {
                    floor = arr[i];
                }
            }

            if(arr[i] >= x) {
                if(ceil == -1 || arr[i] < ceil) {
                    ceil = arr[i];
                }
            }
        }

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        int[] arr = {5,6,8,9,6,5,5,6};
        int[] res = getFloorAndCeil(7, arr);
        System.err.println(res[0]+" "+res[1]);
    }
}
