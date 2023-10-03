//Time: O(1)
//Space: O(n)

class MyHashMap {
    class KeyValuePair {
        int key;
        int value;

        public KeyValuePair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    List<KeyValuePair>[] storage;
    int buckets;

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new ArrayList[buckets];
    }

    private int hash(int key) {
        return key % buckets;
    }

    public void put(int key, int value) {
        int hash = hash(key);

        if (storage[hash] == null) {
            storage[hash] = new ArrayList<>();
        }

        for (KeyValuePair pair : storage[hash]) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        storage[hash].add(new KeyValuePair(key, value));
    }

    public int get(int key) {
        int hash = hash(key);

        if (storage[hash] != null) {
            for (KeyValuePair pair : storage[hash]) {
                if (pair.key == key) {
                    return pair.value;
                }
            }
        }

        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);

        if (storage[hash] != null) {
            storage[hash].removeIf(pair -> pair.key == key);
        }
    }
}
