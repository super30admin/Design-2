// Time Complexity : O(1) for all 
// Space Complexity : O(N) worst case  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//HashMap with Double Hashing
// In this we use a 2D vector of fixed size(chosen based on constraints). For a given key, we hash the key twice to determine the 2D array location 
// where the key will be added into. We dynamically create the second vectors in each location depending on whether or not we recieve an element in that
// location index after hashing.

class MyHashMap {
public:
    vector<vector<int>> storage;
    int buckets;
    int bucketItems;
    
    MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage.resize(buckets);
    }
    
    int hash1(int key){
        return key%buckets;
    }
    
    int hash2(int key){
        return key/bucketItems;
    }
    
    void put(int key, int value) {
        int a = hash1(key);
        int b = hash2(key);
        if(storage[a].empty()){
            if(a==0){
                storage[a]=vector<int> (bucketItems+1,-1); 
            }
            else{
                storage[a]=vector<int> (bucketItems,-1); 
            }
        }
        storage[a][b] = value;
    }
    
    int get(int key) {
        int a = hash1(key);
        int b = hash2(key);
        if(storage[a].empty()) return -1;
        return storage[a][b];
    }
    
    void remove(int key) {
         int a = hash1(key);
         int b = hash2(key);
         if(storage[a].empty()) return;
         storage[a][b]=-1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
