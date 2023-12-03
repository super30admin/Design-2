class MyHashMap {

    private Entry[] buckets;
    private int capacity;
    private int size;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[capacity];
        this.size = 0;
    }

    private int hash(int key) {
        return (key % capacity);
    }

    private Entry[] resize() {
        int newCapacity = capacity * 2;
        Entry[] newBuckets = new Entry[newCapacity];

        for (Entry entry : buckets) {
            while (entry != null) {
                int hash = hash(entry.key);
                Entry newEntry = new Entry(entry.key, entry.value);
                newEntry.next = newBuckets[hash];
                newBuckets[hash] = newEntry;
                entry = entry.next;
            }
        }

        return newBuckets;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Entry entry = buckets[hash];

        while (entry != null) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[hash];
        buckets[hash] = newEntry;
        size++;

        if (size > capacity * 0.75) {
            buckets = resize();
            capacity *= 2;
        }
    }

    public int get(int key) {
        int hash = hash(key);
        Entry entry = buckets[hash];

        while (entry != null) {
            if (entry.key == key) {
                return entry.value;
            }
            entry = entry.next;
        }

        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Entry prev = null;
        Entry entry = buckets[hash];

        while (entry != null) {
            if (entry.key == key) {
                if (prev == null) {
                    buckets[hash] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }

    private static class Entry {
        int key;
        int value;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
