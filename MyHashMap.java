class MyHashMap {
    int primaryBuckets;
    int secondaryBuckets;
    int[][] storage;

    public MyHashMap() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new int[primaryBuckets][]; 
    }

    private int getPrimaryHash(int key){
        return key % primaryBuckets;
    }

    private int getSecondaryHash(int key){
        return key / secondaryBuckets;
    }
    
    public void put(int key, int value) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            if(primaryIndex == 0){
                storage[primaryIndex] = new int[secondaryBuckets+1];
            }else{
                storage[primaryIndex] = new int[secondaryBuckets];
            }
            Arrays.fill(storage[primaryIndex], -1);
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = value;
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = -1;
    }
    
    public int get(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return -1;
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}
