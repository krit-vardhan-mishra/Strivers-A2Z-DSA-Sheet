class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        top++;
        arr[top] = x;
    }

    public int pop() {
        if(top > -1) return arr[top--];
        else return -1;
    }
}

public class ImplementStackUsingArray {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        System.out.println(stack.pop());
    }
}
