/*
implemented by Star Li on 29 June
*/
public class ArrayQueneForString {

    private String[] arr;
    private int first, last;

    public ArrayQueneForString() {
        this.arr = new String[1];
    }

    public void resize(int capacity) {
        String[] oldArr = this.arr;
        this.arr = new String[capacity];

        int newIndex = 0;
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] != null)
                this.arr[newIndex++] = oldArr[i];
        }
    }

    public boolean isEmpty() {
        return this.arr[first] == null;
    }

    public String dequene() {
        if (isEmpty())
            throw new IllegalArgumentException("cannot dequene from an empty quene");

        String data = this.arr[first];
        this.arr[first] = null;

        if (this.first != this.last)
            first++;

        if (this.last - this.first + 1 < this.arr.length / 4) {
            resize(this.arr.length / 2);
            this.last = this.last - this.first;
            this.first = 0;
        }
        
        return data;
    }

    public void enquene(String data) {
        if (this.last == this.arr.length - 1) resize(this.arr.length*2);
        // if (isEmpty()) this.arr[last] = data;
        if (isEmpty())
            this.arr[last] = data;
        else 
            this.arr[++last] = data;
    }

    public static void main(String[] args) {
        ArrayQueneForString quene = new ArrayQueneForString();
        quene.enquene("hello");
        quene.enquene("world");
        System.out.println(quene.dequene());
        System.out.println(quene.dequene());
        System.out.println(quene.isEmpty());
    }
}

// 0       1
// hello   world   
// h = 0
// l = 1