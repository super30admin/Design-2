// Time complexity is O(1) for all opeartions
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took me some time to figure out vector of vector of ints is a good choice.


// Your code here along with comments explaining your approach:
/*
 I have implemented the hashSet using double hashing.
 The size of vector of vector of ints is initialized as 1000.
 During add operation,After finding that buckets[index1] is empty we will assign a
 vector of ints of size 1001 and all elements are initilaized to 0.
 */
class MyHashSet {
public:
    /** Initialize your data structure here. */
    
    vector<vector<int>> buckets;
    MyHashSet() {
        buckets.resize(1000);
    }
    
    int hash1(int key){
        return key%1000;
    }
    
    int hash2(int key){
        return key/1000;
    }
    
    void add(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if (buckets[index1].empty())
            buckets[index1] = vector<int>(1001, 0);
        buckets[index1][index2] = 1;
    }
    
    void remove(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(buckets[index1].empty()) return;
        buckets[index1][index2] = 0;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(buckets[index1].empty()) return 0;
        return buckets[index1][index2];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
