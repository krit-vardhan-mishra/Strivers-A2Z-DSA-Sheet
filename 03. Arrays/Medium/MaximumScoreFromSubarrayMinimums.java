import java.util.ArrayList;
import java.util.List;

// Ques Link : https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0?category&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=max-sum-in-sub-arrays
public class MaximumScoreFromSubarrayMinimums {

    public static int pairWithMaxSum(List<Integer> arr) {

        int maxSum = arr.get(0) + arr.get(1);
        
        for (int i = 1; i < arr.size() - 1; i++) {
            int sum = arr.get(i) + arr.get(i + 1);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);      
        arr.add(3);      
        arr.add(1);      
        arr.add(5);      
        arr.add(6);      
        System.out.println(pairWithMaxSum(arr));
    }
}
