// TC O(1) for all operations
// SC O(1) 
// Implemented hashmap using double hashing collision strategy 
class MyHashMap {

    private final int baseBucketSize;
    private final int nestedBucketSize;
    private final Integer[][] hashMap;


    public MyHashMap() {
        this.baseBucketSize = 1000;
        this.nestedBucketSize = 1000;
        this.hashMap = new Integer[1000][];
    }

    private int hashFuncMod(int key){
        return key % baseBucketSize;
    }

    private int hashFuncDiv(int key){
        return key / nestedBucketSize;
    }
    
    public void put(int key, int value) {
        
        int baseBucketIndex = hashFuncMod(key);
        int nestedBucketIndex = hashFuncDiv(key);

        if(hashMap[baseBucketIndex] == null){
           hashMap[baseBucketIndex] = new Integer[baseBucketIndex == 0 ? nestedBucketSize + 1 : nestedBucketSize];
            hashMap[baseBucketIndex][nestedBucketIndex] = value;
        } else {
            hashMap[baseBucketIndex][nestedBucketIndex] = value;
        }
    }
    
    public int get(int key) {
        int baseBucketIndex = hashFuncMod(key);
        int nestedBucketIndex = hashFuncDiv(key);
        if(hashMap[baseBucketIndex] == null) return -1;
        if(hashMap[baseBucketIndex][nestedBucketIndex] == null) return -1;
        return hashMap[baseBucketIndex][nestedBucketIndex];
    }
    
    public void remove(int key) {
        int baseBucketIndex = hashFuncMod(key);
        int nestedBucketIndex = hashFuncDiv(key);
        if(hashMap[baseBucketIndex] == null) return;
        if(hashMap[baseBucketIndex][nestedBucketIndex] == null) return;
        hashMap[baseBucketIndex][nestedBucketIndex] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */