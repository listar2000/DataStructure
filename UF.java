public class UF {

    public int [] id;

    public UF(int n) {
        id = new int [n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        if (p >= id.length || q >= id.length) {
            throw new RuntimeException("input nums are larger than max length");
        }
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) 
                id[i] = qid;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public static void main(String[] args) {
        UF uf = new UF(10);
        uf.union(1, 2);
        uf.union(2, 5);
        System.out.println(uf.connected(1, 5));
        System.out.println(uf.connected(3, 7));
    }
}