// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No (Failed for some really weird big test case and the diff shown by them has no errors
// meaning it is some really long set of operations and I'm not really sure where it is failing. Says 27/36 test cases passed) 
class MyHashMap {
    int keyRange;
    int[][] map;

    public MyHashMap() {
        keyRange = 1000;
        map = new int[keyRange][];
    }

    // Time Complexity: O(1)
    private int hash1(int key) {
        return key % keyRange;
    }

    // Time Complexity: O(1)
    private int hash2(int key) {
        return key / keyRange;
    }

    // Time Complexity: O(1)
    private boolean contains(int key) {
        int pIdx = hash1(key);
        return map[pIdx] != null;
    }
    
    // Time Complexity: O(1)
    public void put(int key, int value) {
        int pIdx = hash1(key);
        if (map[pIdx] == null) {
            int n = keyRange;
            // Handle the edge case where on the 0th bucket we need to store "1000000/1000 = 1000"
            // and bucket would only have 999 elements so add 1 more to it.
            if (pIdx == 0) {
                n += 1;
            }

            map[pIdx] = new int[n];
        }

        int sIdx = hash2(key);
        map[pIdx][sIdx] = value;
    }
    
    // Time Complexity: O(1)
    public int get(int key) {
        if (contains(key)) {
            int pIdx = hash1(key);
            int sIdx = hash2(key);
            return map[pIdx][sIdx];
        }

        return -1;
    }
    
    // Time Complexity: O(1)
    public void remove(int key) {
        if (contains(key)) {
            int pIdx = hash1(key);
            int sIdx = hash2(key);
            map[pIdx][sIdx] = -1;
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