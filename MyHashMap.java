// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Created a parent list which resembles buckets of a fixed size - 1000
// 2. Computed an index to place the key by modulo of key and fixed size
// 3. To tackle collision, create a linkedlist at the computed index. If list exists at that index and doesn't contain the key - value pair, add it. If key exists, update the corresponding value for it. If list doesn't exist at the index, create list and add key - value pair
// 4. To remove key - value pair, get the appropriate index for the bucket and remove the key - value pair from the list at that index if key exists, else no operation required
// 5. Check if key - value pair is present within the list at the computed index for the buckets, if present return the value for that key

class Pair {
    public Integer key;
    public Integer value;
    
    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }
    
    public Integer getKey() {
        return this.key;
    }
    
    public void setKey(Integer key) {
        this.key = key;
    }
}

class MyHashMap {
    
    private final int SIZE = 1000;
    List<List<Pair>> buckets;

    public MyHashMap() {
        this.buckets = new ArrayList<>(SIZE);
        for(int i = 0; i < SIZE; i++) {
            buckets.add(null);
        }
    }
    
    public void put(int key, int value) {
        Integer index = hash(key);
        List<Pair> bucketList = buckets.get(index);
        if(bucketList == null) {
            LinkedList<Pair> list = new LinkedList<>();
            list.add(new Pair(key, value));
            buckets.set(index, list);
        }
        else {
            boolean found = false;
            for(Pair pair: bucketList) {
                if(pair.getKey().equals(key)) {
                    pair.setValue(value);
                    found = true;
                }
            }
            if(!found) {
                bucketList.add(new Pair(key, value));
            }
        }
    }
    
    public int get(int key) {
        Integer index = hash(key);
        List<Pair> bucketList = buckets.get(index);
        if(bucketList != null) {
            for(Pair pair: bucketList) {
                if(pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        Integer index = hash(key);
        List<Pair> bucketList = buckets.get(index);
        if(bucketList != null) {
            for(Pair pair: bucketList) {
                if(pair.getKey().equals(key)) {
                    bucketList.remove(pair);
                    break;
                }
            }
        }
    }
    
    public Integer hash(Integer key) {
        return key % SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */