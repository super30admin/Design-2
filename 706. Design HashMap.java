// Firstly create an array as Node datatype and taking sqareroot for size for instace
// now use a dummy node to traverse through inner linkedlist using prev and curr pointers

// Time Complexity O(1) average case

class MyHashMap {

//create node
    class node {
        int key;
        int value;
        node next;

        node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    node[] storage;

    public MyHashMap() {                              // Time O(1)
        // this creates new array for hashmap
        this.storage = new node[1000];
    }

    int hash1(int key) {
        return key % 1000;
    }

    public void put(int key, int value) {

        // index
        int bucket = hash1(key);

        // check if there are no numbers
        if (storage[bucket] == null) {

            // add a dummy node to use it as prev
            node dummy = new node(-1, -1);
            storage[bucket] = dummy;

        }
        node prev = storage[bucket];
        node curr = prev.next;

        // check if key is present or not
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = prev.next;
        }
        // key is present, so change value
        if (curr != null) {
            curr.value = value;
        } else {
            // as there is no key, create new pair
            prev.next = new node(key, value);
        }

    }

    public int get(int key) {
        int bucket = hash1(key);

        if (storage[bucket] == null) {
            return -1;
        }
        node curr = storage[bucket].next;
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }
        if (curr != null) {
            return curr.value;
        } else {
            return -1;
        }

    }

    public void remove(int key) {
        int bucket = hash1(key);

        if (storage[bucket] == null) {
            return;
        }
        node prev = storage[bucket];
        node curr = prev.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
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
