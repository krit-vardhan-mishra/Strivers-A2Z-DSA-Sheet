import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int j = i + 1, r = n - 1;
            while (j < r) {
                int sum = arr[j] + arr[r] + arr[i];
                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[r]));
                    while (j < r && arr[j] == arr[j + 1])
                        j++;
                    while (j < r && arr[r] == arr[r - 1])
                        r--;
                    j++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(arr));
    }
}
