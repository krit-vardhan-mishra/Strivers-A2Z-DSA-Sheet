public class MyStack {
    private int[] arr;
    private int index;

    MyStack() {
        arr = new int[100];
        index = -1;
    }

    public void push(int x) {
        index++;
        arr[index] = x;
    }

    public int pop() {
        if(empty()) return -1;
        return arr[index--];
    }

    public int top() {
        if(index > -1) return arr[index];
        else return -1;
    }

    public boolean empty() {
        return index == -1;
    }
}