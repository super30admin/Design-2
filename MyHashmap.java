// Time Complexity : O(N / k) where N is the number of keys and k is the size of the map
// Space Complexity : O(N / k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


import java.util.LinkedList;

/**
 * For HashMap, a LinkedList of Pair<Key, Value> array is used, similar to HashSet implementation.
 * for Put: calculate the hash. Fetch the list from that hash index in map. if not found, put a pair
 * of <key, value> in that list and update the hash index in map with this list. If list is found, check
 * if any pair has the key already, if so replace the value with the new one else, just add another pair 
 * to the list.
 * for Get: Calculate the hash. If a list is found in that hash index, iterate over the pairs and find the key
 * to return the value. If not found, return -1. If list is not found, return -1 directly.
 * for Remove: Calculate the hash. If a list is found, iterate over the list and remove the pair if key is present.
 * if not found, just return.
 */
class MyHashMap {
    LinkedList<Pair> map[];
    public MyHashMap() {
        map = new LinkedList[769];
    }
    
    public void put(int key, int value) {
        int hash = _hash(key);
        LinkedList<Pair> keySet = map[hash];
        if(keySet == null) {
            keySet = new LinkedList<>();
            keySet.add(new Pair(key, value));
            map[hash] = keySet;
        } else {
            for(Pair p : keySet) {
                if(key == p.key) {
                    p.value = value;
                    return;
                }
            }
            keySet.add(new Pair(key, value));
        }
    }
    
    public int get(int key) {
        int hash = _hash(key);
        LinkedList<Pair> keySet = map[hash];
        if(keySet == null) {
            return -1;
        } else {
            for(Pair p : keySet) {
                if(key == p.key)
                    return p.value;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
        int hash = _hash(key);
        LinkedList<Pair> keySet = map[hash];
        if(keySet == null) {
            return;
        }
        Pair rem = null;
        for(Pair p : keySet) {
            if(key == p.key) {
                rem = p;
            }
        }
        keySet.remove(rem);
    }

    public int _hash(int key) {
        return key % map.length;
    }
}

class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
