import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        
        int mid = arr.length / 2;
        int[] leftArr = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        
        return mergeArr(leftArr, rightArr);
    }
    
    public static int[] mergeArr(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        
        int i = 0, j = 0, k = 0;
        int[] arr3 = new int[len];
        while(i<arr1.length && j<arr2.length) {
            if(arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while(i<arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while(j<arr2.length) {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
}
