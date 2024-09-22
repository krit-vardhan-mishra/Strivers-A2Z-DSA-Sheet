
class MyQueue {
    int front, rear;
    int arr[] = new int[1000005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    void push(int x) {
        arr[rear] = x;
        rear++;
    }

    int pop() {
        if(front == rear) return -1;
        else return arr[front++];
    }
}

public class ImplementQueueUsingArray {

    
}