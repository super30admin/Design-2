// Time Complexity : O(n) for add and remove because we search through list to find if key exists
// Space Complexity : O(K + M) k is the size of initial array, in this case 1000, and M is the entries inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes initially did not think about checking null bucket.

public class HashMap {
    LinkedList<Entry>[] map;
    int size = 1000;

    public MyHashMap() {
        map = new LinkedList[size];
    }

    public void put(int key, int value) {
        int bucket = key % size;
        if(map[bucket] == null){
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        }else{
            for(Entry e : map[bucket]){
                if(e.key == key){
                    e.value = value;
                    return;
                }
            }
            map[bucket].add(new Entry(key, value));
        }

    }

    public int get(int key) {
        int bucket = key % size;
        if(map[bucket] == null){
            return -1;
        }
        for(Entry e : map[bucket]){
            if(e.key == key){
                return e.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = key % size;
        if(map[bucket] == null){
            return;
        }else{
            for(Entry e : map[bucket]){
                if(e.key == key){
                    map[bucket].remove(e);
                    return;
                }
            }
        }
    }
}

class Entry{
    int key;
    int value;

    public Entry(int key, int value){
        this.key = key;
        this.value = value;
    }
}
