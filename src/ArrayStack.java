public class ArrayStack<T> implements Stack<T> {
    private int maxsize;
    private int top;
    private T[] nodes;

    public ArrayStack(int n) {
        maxsize = n;
        top = -1;
        nodes = (T[]) new Object[n];
    }

    public T pop() {
        return nodes[top--];

    }

    public void push(T e) {
        nodes[++top] = e;
    }

    public boolean empty() {
        return top == -1;

    }

    public boolean full() {
        return top == maxsize - 1;
    }

    public void multiPush(T els[], int k) {
        for (int i = 0; i < k && i < els.length; i++) {
            if(els[i]!=null){
            if (!full()) {
                push(els[i]);
                }
            }
        }
    }

    public void reverse() {
        Stack<T> tempStack1 = new ArrayStack<T>(nodes.length);
        Stack<T> tempStack2 = new ArrayStack<T>(nodes.length);
        while (!empty()) {
            tempStack1.push(this.pop());
        }
        while (!tempStack1.empty()) {
            tempStack2.push(tempStack1.pop());
        }
        while (!tempStack2.empty()) {
            this.push(tempStack2.pop());
        }

    }

    public Stack<T> copy() {
        Stack<T> c = new ArrayStack<T>(this.maxsize);
        Stack<T> cc = new ArrayStack<T>(this.maxsize);

        while (!empty()){
            T xx = pop();
            c.push(xx);
            cc.push(xx);
        }
        while(!cc.empty()){
            push(cc.pop());
        }
        c.reverse();
        return c;
    }
}
