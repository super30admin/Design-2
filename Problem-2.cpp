// Time Complexity : O(1) for all operations
// Space Complexity : O(1) no extra space used for any operation apart from the bucket items in double hashing which are not considered as they're a part of the hashSet
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 
class MyHashSet {
    
private:
    bool arr[1000001]; //assuming 10^4 add operations
    
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        for(int i = 0; i < 1000001; i++){
            arr[i] = false;
        }
        
    }
    
    void add(int key) {
        arr[key] = true;
        return;
        
    }
    
    void remove(int key) {
        arr[key] = false;
        return;
        
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        if(arr[key])
            return true;
        else 
            return false;
    }
};

/////////////////////////////////////////////////////////////////////////// Double Hashing  /////////////////////////////////////

#define buckets 1000
#define bucketItems 1001
class MyHashSet {
    
private:
    bool storage[buckets][bucketItems];
public:
    /** Initialize your data structure here. */
    
    int ret_bucket(int key){
        return key%buckets;
    }
    
    int ret_bucketItem(int key){
        return key/bucketItems;
    }
    
    void add(int key) {
        int bucket = ret_bucket(key);
        int bucketItem = ret_bucketItem(key);
        storage[bucket][bucketItem] = true;
    }
    
    void remove(int key) {
        int bucket = ret_bucket(key);
        int bucketItem = ret_bucketItem(key);
        storage[bucket][bucketItem] = false; 
        
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int bucket = ret_bucket(key);
        int bucketItem = ret_bucketItem(key);
        return storage[bucket][bucketItem];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */