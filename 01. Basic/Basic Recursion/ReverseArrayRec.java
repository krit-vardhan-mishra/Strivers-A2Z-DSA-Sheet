public class ReverseArrayRec {
    public static void reverseArray(int[] arr, int start, int end) {
        if(start >= end) return;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start+1, end-1);
    }
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        reverseArray(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
