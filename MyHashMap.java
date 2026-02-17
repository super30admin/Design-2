class MyHashMap {
    // similar to hashset
    // sqrt size 10 ^ 6
    private int [][] buckets;
    private final int SIZE = 1_000;
    public MyHashMap() {
        buckets = new int [SIZE][];
    }

    public void put(int key, int value) {
        int primary = primaryHash(key);
        int secondary = secondaryHash(key);
        if (buckets[primary] == null) {
            // for 10^6
            buckets[primary] = primary == 0 ? new int[SIZE + 1]: new int[SIZE];
            for (int i = 0; i < buckets[primary].length; i++) {
                buckets[primary][i] = -1;
            }
        }
        buckets[primary][secondary] = value;

    }

    public int get(int key) {
        int primary = primaryHash(key);
        int secondary = secondaryHash(key);
        return buckets[primary] == null ? -1:  buckets[primary][secondary];
    }

    public void remove(int key) {
        int primary = primaryHash(key);
        int secondary = secondaryHash(key);
        if (buckets[primary] == null) return;

        buckets[primary][secondary] = -1;
    }

    private int primaryHash(int key) {
        return key % SIZE;
    }

    private int secondaryHash(int key) {
        return key / SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */