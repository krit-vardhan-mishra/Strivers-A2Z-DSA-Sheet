import java.util.ArrayList;
import java.util.List;

public class SecondLargest {
    public static int print2largest(List<Integer> arr) {
        int max = arr.get(0);
        int secMax = -1;

        for(int i=0; i<arr.size();i++) {
            if(arr.get(i) > max && max > secMax) {
                secMax = max;
                max = arr.get(i);
            }
            if(arr.get(i) < max && secMax < arr.get(i)) {
                secMax = arr.get(i);
            }
        }

        return secMax;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(35);
        arr.add(1);
        arr.add(10);
        arr.add(34);
        arr.add(11);
        System.out.println(print2largest(arr));
    }
}
