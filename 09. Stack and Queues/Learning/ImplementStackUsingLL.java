
public class ImplementStackUsingLL {

    class StackNode {
        int data;
        StackNode next;
    
        StackNode(int a) {
            data = a;
            next = null;
        }
    }
    
    class MyStack {
        StackNode top;
    
        void push(int a) {
            StackNode node = new StackNode(a);
            node.next = top;
            top = node;
        }
    
        int pop() {
            if(top == null) {
                return -1;
            } else {
                int res = top.data;
                top = top.next;
                return res;
            }
        }
    }
    
}
