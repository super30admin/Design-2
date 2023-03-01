class MyHashMap {
    private int buckets;
    private int bucketItems;
    int[][] storage;

    public MyHashMap() {
        buckets=1000;
        bucketItems=1000;
        storage = new int[buckets][];
    }

    private int hash1(int key){
        return key%buckets;
    }
    private int hash2(int key){
        return key/buckets;
    }

    public void put(int key, int value) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if(storage[pIdx] == null){
            if(pIdx == 0){
                storage[pIdx] = new int[bucketItems+1];
            }
            else{
                storage[pIdx] = new int[bucketItems];
            }
        }
        storage[pIdx][nIdx] = value;
    }

    public int get(int key) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if(storage[pIdx] == null) return -1;
        else return storage[pIdx][nIdx];
    }

    public void remove(int key) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if(storage[pIdx] == null) return;
        storage[pIdx][nIdx] = -1;
    }

    public static void main(String[] args) {
         MyHashMap obj = new MyHashMap();
         obj.remove(14);
         obj.get(4);
         obj.put(7,3);
         obj.put(7,3);
         obj.put(11,1);
         obj.put(12,1);
         obj.get(7);
         obj.put(1,9);
         obj.put(0,3);
         obj.put(1,8);
         obj.put(2,6);
    }
}
