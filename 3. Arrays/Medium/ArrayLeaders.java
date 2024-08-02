import java.util.ArrayList;

public class ArrayLeaders {

    public static ArrayList<Integer> leaders(int n, int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> rev = new ArrayList<>();
        int maxEle = arr[n-1];

        ans.add(maxEle);
        for (int i = n-2; i >= 0; i--) {
            if(maxEle <= arr[i]) {
                maxEle = arr[i];
                ans.add(maxEle);
            }
        }

        for(int i=ans.size()-1; i >= 0; i--) rev.add(ans.get(i));

        return rev;
    }

    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};
        System.out.println(leaders(arr.length, arr));
    }
    
}