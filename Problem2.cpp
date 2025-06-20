// Time Complexity : O(l) for put, remove and get operations
// Space Complexity : O(n) where n is the number of elements in the hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
using namespace std;

class MyHashMap {

private:
    static const int SIZE = 1009;
    vector<pair<int, int>> buckets[SIZE];

    int hash(int key) {
        return key % SIZE;
    }
    
public:
    MyHashMap() {}
    
    void put(int key, int value) {
        int index = hash(key);
        for (auto& p : buckets[index]) {
            if (p.first == key) {
                p.second = value;
                return;
            }
        }
        buckets[index].push_back({key, value});        
    }
    
    int get(int key) {
        int index = hash(key);
        for (auto& p : buckets[index]) {
            if (p.first == key) {
                return p.second;
            }
        }
        return -1;        
    }
    
    void remove(int key) {
        int index = hash(key);
        auto& bucket = buckets[index];
        for (auto it = bucket.begin(); it != bucket.end(); ++it) {
            if (it->first == key) {
                bucket.erase(it);
                return;
            }
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