/*
* 树状数组 - by Star
* 2018.7.30
*/

public class BinaryIndexTree {
    private int length;
    private int[] tree;

    public BinaryIndexTree(int N) {
        this.length = N;
        this.tree = new int[N + 1];
    }

    public BinaryIndexTree(int[] arr) {
        this.length = arr.length;
        this.tree = new int[length + 1];

        for (int i = 0; i < arr.length; i++) {
            update(i + 1, arr[i]);
        }
    }

    private int lowBit(int k) {
        return k & -k;
    }

    public int sum(int a) {
        if (a < 1 || a > length) {
            throw new IllegalArgumentException();
        }
        int sum = 0;

        while (a > 0) {
            sum += tree[a];
            a -= lowBit(a);
        }

        return sum;
    }

    public int sum(int start, int end) {
        if (start == 1) return sum(end);
        return sum(end) - sum(start - 1);
    }

    public int get(int pos) {
        return sum(pos, pos);
    }

    public void update(int pos, int val) {
        if (pos < 1 || pos > length) throw new IllegalArgumentException();
        while (pos <= length) {
            tree[pos] += val;
            pos += lowBit(pos);
        }
    }

    public static void main(String[] args) {
        int[] demo = {6,5,4,3,2,1};
        BinaryIndexTree bit = new BinaryIndexTree(demo);
        bit.update(2, -2);
        System.out.println(bit.get(4));
    }
}