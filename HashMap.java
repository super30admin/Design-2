import java.util.Arrays;

// Time Complexity : Put O(N); others O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class MyHashMap {
    private int[][] map;
    private int buckets;
    private int bucketSize;
        public MyHashMap() {
            buckets = 1000;
            bucketSize = 1001;
            map = new int[buckets][];
        }
    
        public int hash(int key){
            return key%buckets;
        }
    
        public int hash2(int key){
            return key/buckets;
        }
        
        public void put(int key, int value) {
            int hash = hash(key);
            int hash2 = hash2(key);
            if(map[hash] != null){
                map[hash][hash2]= value;
            }
            else{
                map[hash] = new int[bucketSize];
                Arrays.fill(map[hash], -1);
                map[hash][hash2]=value;
            }
        }
        
        public int get(int key) {
            int hash = hash(key);
            int hash2 = hash2(key);
            if(map[hash] == null)
            return -1;
            return map[hash][hash2];
        }
        
        public void remove(int key) {
             int hash = hash(key);
            int hash2 = hash2(key);
            if(map[hash] != null)
            map[hash][hash2] = -1;
    
        }
    }
    
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */