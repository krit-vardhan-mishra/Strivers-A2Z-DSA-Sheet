import java.util.ArrayList;
import java.util.List;

public class SubsetSumsOne {

    /* 
    // Space Complexity O(2^n) & Space Complexity O(2^n)
    public static ArrayList<ArrayList<Integer>> funcReturn(ArrayList<Integer> arr, List<Integer> up, int idx) {
        if (idx == arr.size()) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>(up));
            return ans;
        }

        int ch = arr.get(idx);
        ArrayList<ArrayList<Integer>> l = funcReturn(arr, up, idx+1);
        up.add(ch);
        ArrayList<ArrayList<Integer>> r = funcReturn(arr, up, idx+1);
        up.remove(up.size()-1);
        l.addAll(r);
        return l;
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> combinations = funcReturn(arr, new ArrayList<>(), 0);

        for (ArrayList<Integer> arrayList : combinations) {
            int sum = 0;
            for (Integer arrayList2 : arrayList) {
                sum += arrayList2;
            }
            ans.add(sum);
        }

        return ans;
    }
    */

    // Time Complexity O(2^n) & Space Complexity O(n)
    public static void subsetSums(ArrayList<Integer> arr, int n, int index, int currSum, List<Integer> result) {
        if(index == n) {
            result.add(currSum);
            return;
        }

        subsetSums(arr, n, index+1, currSum, result);
        subsetSums(arr, n, index+1, currSum+arr.get(index), result);
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        subsetSums(arr, n, 0, 0, result);
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(1);
        System.out.println(subsetSums(arr, arr.size()));
    }
}
