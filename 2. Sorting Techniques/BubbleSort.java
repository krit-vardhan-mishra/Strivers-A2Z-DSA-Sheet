public class BubbleSort {
    public static void bubbleSort(int[] a) {
		int n = a.length;
		boolean swapped;
		for (int i = 0; i < n; i++) {
			swapped = false;
			for (int j = 1; j < n - i; j++) {
				if (a[j] < a[j - 1]) {
					int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

}
