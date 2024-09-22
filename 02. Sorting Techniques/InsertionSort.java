public class InsertionSort {
    public static void insertionSort(int[] arry) {
		for (int i = 0; i < arry.length - 1; i++) {			
			for (int j = i + 1; j > 0; j--) {
				if (arry[j] < arry[j - 1]) {
                    int temp = arry[j];
                    arry[j] = arry[j-1];
                    arry[j-1] = temp;
				}
			}
		}
	}
}
