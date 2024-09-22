class QueueNode {
    int data;
    QueueNode next;
    QueueNode(int a) {
        data = a;
        next = null;
    }
}

class MuQueue {
    QueueNode front, rear;

    void push(int a) {
        QueueNode temp = new QueueNode(a);
        if(front == null) {
            rear = front = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    int pop() {
        if(front == null) return -1;
        else {
            int res = front.data;
            front = front.next;
            if(front == null) rear = null;
            return res;
        }
    }
}

public class ImplementQueueUsingLL {
    
}
