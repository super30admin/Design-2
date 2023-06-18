class Entry {
    int key;
    Entry next; // for chaining

    Entry(int key) {
        this.key = key;
    }
}

/**
 * Design HashSet
 * Space Complexity: O(n)
 * Time Complexity:
 * add(int key), remove(int key), contains(int key): O(1), O(n) in worst case
 * 
 */
class MyHashSet {

    int MAX_SIZE = 10000;
    Entry[] entries;

    /** Initialize your data structure here. */
    public MyHashSet() {
        entries = new Entry[MAX_SIZE];
    }

    public void add(int key) {
        int i = index(key);
        if (entries[i] == null) {
            // -1 indicates "dummy" node
            entries[i] = new Entry(-1);
        }
        Entry prev = linearFind(entries[i], key);
        if (prev.next == null) {
            // end of list reached, not found
            prev.next = new Entry(key);
        }
    }

    public void remove(int key) {
        int i = index(key);
        if (entries[i] == null) {
            return;
        }
        Entry prev = linearFind(entries[i], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = index(key);
        if (entries[i] == null) {
            return false;
        }
        Entry prev = linearFind(entries[i], key);
        if (prev.next == null) {
            return false;
        }
        return true;
    }

    private int index(int key) {
        return Integer.hashCode(key) % MAX_SIZE;
    }

    private Entry linearFind(Entry bucket, int key) {
        Entry cursor = bucket, prev = null;
        while (cursor != null && cursor.key != key) {
            prev = cursor;
            cursor = cursor.next;
        }
        return prev;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: 
 * MyHashSet obj = new MyHashSet(); 
 * obj.add(key); 
 * obj.remove(key); 
 * boolean param_3 = obj.contains(key);
 */