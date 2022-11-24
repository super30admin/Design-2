//Time Complexity :O(1)
//Space Complexity :O(n)
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :

class MyHashMap {

    Pair<Integer,Integer>[][] map;
    int buckets;
    int bucketItems;
    public MyHashMap() {
        buckets= 1000;
        bucketItems = 1000;
        map = new Pair[buckets][];
    }
    
    public int hash1(int key){
        return key % buckets;
    }
    
    public int hash2(int key){
        return key / buckets;
    }
    
    public void put(int key, int value) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(map[bucket]==null){
            if(bucket==0)
                map[bucket] = new Pair[bucketItems+1];
            else
            map[bucket] = new Pair[bucketItems];
        }
        map[bucket][bucketItem] = new Pair<Integer,Integer>(key,value);
    }
    
    public int get(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(map[bucket]==null||map[bucket][bucketItem]==null)
            return -1;
        else{
            return map[bucket][bucketItem].getValue();
        }    

    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(map[bucket]==null)
            return ;
        else{
             map[bucket][bucketItem]=null;
        }    
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */