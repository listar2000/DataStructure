public class Percolation {

    public int N;
    public int[] id;
    public int[] sz;
    public boolean[] isOpen;
    public WeightedQuickUnionUF uf;

    public Percolation(int N) {
        this.N = N;
        id = new int[N*N + 2];
        sz = new int[N*N + 2];
        isOpen = new boolean[N*N + 2];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void open(int n) {
        if (n < 1 || n > id.length - 1) {
            throw new RuntimeException("index error: can only be from 1 to " + (id.length - 1));
        }
        isOpen[n] = true;
        if (n <= N) {
            union(n, 0);
            if (isOpen[n + N])
                union(n, n + N);
        }
        else if (n > (N*N - N)) {
            union(n, id.length - 1);
            if (isOpen[n - N]) 
                union(n, n - N);            
        }
        else if (n % N == 1) {
            if (isOpen[n + 1])
                union(n, n + 1);
            if (isOpen[n + N])
                union(n, n + N);
            if (isOpen[n - N])
                union(n, n - N);
        }
        else if (n % N == 0) {
            if (isOpen[n - 1])
                union(n, n - 1);
            if (isOpen[n + N])
                union(n, n + N);
            if (isOpen[n - N])
                union(n, n - N);
        }
        else {
            if (isOpen[n + N])
                union(n, n + N);
            if (isOpen[n - N])
                union(n, n - N);
            if (isOpen[n + 1])
                union(n, n + 1);
            if (isOpen[n - 1])
                union(n, n - 1);
        }
    }

    public boolean isPenetrated() {
        return connected(0, id.length - 1);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
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

    public int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public static void main(String[] args) {
        Percolation s = new Percolation(5);
        s.open(2);
        s.open(7);
        s.open(8);
        s.open(13);
        s.open(14);
        s.open(19);
        s.open(24);
        System.out.println(s.isPenetrated());
    }
}
