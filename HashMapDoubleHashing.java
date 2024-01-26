class MyHashMap {
    
    private int[][] map;
    private int bucket;
    private int bucketItem;

    public MyHashMap() {
        this.bucket = 1000;
        this.bucketItem = 1000;
        this.map = new int[this.bucket][];
    }

    private int bucket(int key) {
        return key % this.bucket;
    }
    private int bucketItem(int key) {
        return key / this.bucketItem;
    }
    public void put(int key, int value) {
        int idx = bucket(key);
        int idxItem = bucketItem(key);
        if (map[idx] == null) {
            if (idx == 0)
                map[idx] = new int[this.bucketItem + 1];
            else map[idx] = new int[this.bucketItem];

            for (int i = 0; i < map[idx].length; i++) {
                map[idx][i] = -1;
            }
        }

        map[idx][idxItem] = value;
        
    }
    
    public int get(int key) {
        int idx = bucket(key);
        int idxItem = bucketItem(key);
        if (map[idx] == null) return -1;

        if (map[idx][idxItem] == -1) return -1;
        else return  map[idx][idxItem];
    }
    
    public void remove(int key) {
        int idx = bucket(key);
        int idxItem = bucketItem(key);
        if (map[idx] == null) return ;

        if (map[idx][idxItem] == -1) return ;
        else map[idx][idxItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */