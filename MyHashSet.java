//Design a Hash Set - Double Hashing Solution
//Time Complexity : O(1)
//Space Complexity : O(n)

public class MyHashSet {
    boolean[][] set;
    int pbucket;
    int sbucket;

    public MyHashSet() {
        this.pbucket = 1000;
        this.sbucket = 1000;
        this.set = new boolean[pbucket][];
    }

    public void add(int key) {
        int hash1 = key%pbucket;
        if(set[hash1] == null) {
            //initiate the array
            if(hash1 == 0)
                set[hash1] = new boolean[sbucket+1];
            else
                set[hash1] = new boolean[sbucket];
        }
        int hash2 = key/sbucket;
        set[hash1][hash2] = true;
    }

    public void remove(int key) {
        int hash1 = key%pbucket;
        if(set[hash1] != null) {
            int hash2 = key/sbucket;
            set[hash1][hash2] = false;
        }
    }

    public boolean contains(int key) {
        int hash1 = key%pbucket;
        if(set[hash1] == null) {
            return false;
        }
        int hash2 = key/sbucket;
        return set[hash1][hash2];
    }
}
