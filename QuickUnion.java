import com.sun.glass.ui.Size;

public class QuickUnion {

    public int[] id;
    public int[] sz;

    public QuickUnion(int N) {
        sz = new int[N];
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] >= sz[j]) {
            id[j] = i;
            sz[i] += sz[j];
        }
        else {
            id[i] = j;
            sz[j] += sz[i];
        }
    }

    public int root(int p) {
        int q = p;
        while (id[p] != p) {
            p = id[p];
        }
        //The second loop is used to assign each node on the path to its original node
        while (id[q] != q) {
            id[q] = p;
            q = id[q];
        }
        return p;
    }

    public int size(int i) {
        return sz[i];
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        qu.union(1, 2);
        qu.union(2, 5);
        qu.union(2, 5);
        System.out.println(qu.connected(1, 5));
        System.out.println(qu.connected(2, 8));
        System.out.println(qu.size(1));
        System.out.println(qu.size(2));
    }
}