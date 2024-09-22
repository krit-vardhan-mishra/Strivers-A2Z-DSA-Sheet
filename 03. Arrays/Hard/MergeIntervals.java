import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] arr) {
        if(arr.length == 0) {
            return new int[0][];
        }
        
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
        
        for(int i=0;i<n;i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)) {
                continue;
            }
            for(int j=i+1;j<n;j++) {
                if(arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(Arrays.deepToString(merge(arr)));
    }
}
