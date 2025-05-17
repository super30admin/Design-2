// Open addressing with linear probing.
// Put, get and remove operations are amortized O(1)
class MyHashMap {
    static const int SIZE = 5007;
    
    struct Entry {
        int key;
        int value;
        bool occupied;
        Entry(int k, int v) : key(k), value(v), occupied(true) {}
    };
    
    vector<unique_ptr<Entry>> table;

    int hash(int key) {
        return key % SIZE;
    }

public:
    MyHashMap() : table(SIZE) {}
    
    void put(int key, int value) {
        int idx = hash(key);
        int start = idx;
        while (table[idx] != nullptr && table[idx]->occupied && table[idx]->key != key) {
            idx = (idx + 1) % SIZE;
            if (idx == start) return;
        }
        table[idx] = make_unique<Entry>(key, value);
    }
    
    int get(int key) {
        int idx = hash(key);
        int start = idx;
        while (table[idx] != nullptr) {
            if (table[idx]->occupied && table[idx]->key == key) {
                return table[idx]->value;
            }
            idx = (idx + 1) % SIZE;
            if (idx == start) break;
        }
        return -1;
    }
    
    void remove(int key) {
        int idx = hash(key);
        int start = idx;
        while (table[idx] != nullptr) {
            if (table[idx]->occupied && table[idx]->key == key) {
                table[idx]->occupied = false;
                return;
            }
            idx = (idx + 1) % SIZE;
            if (idx == start) break;
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */