import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class FindUnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        
        for (int i = 0; i < m; i++) {
            set.add(arr2[i]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int s : set) {
            ans.add(s);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,6,7};
        ArrayList<Integer> ans = findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.println(ans);
    }
}
