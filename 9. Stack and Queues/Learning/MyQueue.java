public class MyQueue {
    private int[] arr;
    private int front = 0;
    private int rear = 0;

    public MyQueue() {
        arr = new int[100];
    }
    
    public void push(int x) {
        arr[rear++] = x;
    }
    
    public int pop() {
        if(empty()) return -1;
        else return arr[front++];
    }
    
    public int peek() {
        return arr[front];
    }
    
    public boolean empty() {
        return front == rear;
    }
}
