public class TrappinRainWater {

    public static int trap(int[] h) {
        int n = h.length, total = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = h[0];
        rightMax[n-1] = h[n-1];

        for (int i = 1; i < h.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], h[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], h[i]);
        }

        for (int i = 0; i < h.length; i++) {
            total += Math.min(leftMax[i] , rightMax[i]) - h[i];
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        System.out.println(trap(arr));
    }
}

