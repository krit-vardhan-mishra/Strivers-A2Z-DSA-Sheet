
public class ImplementationOfPriorityQueue {
    public static int[] H = new int[10009];
    public static int s = -1;

    public int parent(int i) {
        return (i - 1) / 2;

    }

    public int leftChild(int i) {
        return ((2 * i) + 1);
    }

    public int rightChild(int i) {
        return ((2 * i) + 2);
    }

    public void shiftUp(int i) {
        while (i > 0 && H[parent(i)] < H[i]) {
            int temp = H[i];
            H[i] = H[parent(i)];
            H[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void shiftDown(int i) {
        int maxIndex = i;
        int l = leftChild(i);
        if (l <= s && H[l] > H[maxIndex]) {
            maxIndex = l;
        }
        int r = rightChild(i);

        if (r <= s && H[r] > H[maxIndex]) {
            maxIndex = r;
        }
        if (i != maxIndex) {
            int temp = H[i];
            H[i] = H[maxIndex];
            H[maxIndex] = temp;
            shiftDown(maxIndex);
        }
    }

    public int size() {
        return s;
    }

    void insert(int p) {
        s = s + 1;
        H[s] = p;
        shiftUp(s);
    }

    public int extractMax() {
        int result = H[0];
        H[0] = H[s];
        s = s - 1;

        shiftDown(0);
        return result;
    }

    void changePriority(int i, int p) {
        int old = H[i];
        H[i] = p;

        if (p > old) shiftUp(i);
        else shiftDown(i);
    }

    public static void main(String[] args) {
        ImplementationOfPriorityQueue list = new ImplementationOfPriorityQueue();
        list.insert(4);
        list.insert(2);
        list.insert(8);
        list.insert(16);
        list.insert(24);
        list.insert(2);
        list.insert(6);
        list.insert(5);

        int i = 0;

        System.out.print("Priority Queue : ");
        while (i <= list.size()) {
            System.out.print(H[i] + " ");
            i++;
        }

        System.out.print("\n");

        // Node with maximum priority
        System.out.print("Node with maximum priority : " +
                list.extractMax() + "\n");

        System.out.print("Priority queue after " +
                "extracting maximum : ");
        int j = 0;
        while (j <= list.size()) {
            System.out.print(H[j] + " ");
            j++;
        }
    }
}
