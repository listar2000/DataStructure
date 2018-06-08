public class LinkedStack<T> {

    private Node<T> head = new Node<>();
    private int top = -1;

    public T pop() {
        if (isEmpty())
            return null;

        Node<T> old = this.head.next;
        this.head.next = this.head.next.next;
        this.top --;

        return old.data;
    }

    public boolean push(T data) {
        if (data == null) {
            return false;
        }
        this.head.next = new Node<T>(data, this.head.next);
        this.top++;
        return true;
    }

    public T peek() {
        if (isEmpty())
            return null;

        return this.head.next.data;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public int size() {
        return this.top + 1;
    }

    public static void main (String [] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}

class Node<T>
{
    public Node<T> next;
    public T data;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node() {}
}
