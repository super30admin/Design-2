// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

//using arrays

class MyHashMap {
public:
    int buckets = 1000;
    int bucketItems = 1000;
    vector<vector<int>>storage = vector<vector<int>>(1000,vector<int>());
    MyHashMap() {
        
    }
    int getbucket(int key){
        return key%buckets;
    }
    int getbucketItem(int key){
        return key/bucketItems;
    }
    
    void put(int key, int value) {
        int bucket = getbucket(key);
        if(storage[bucket].empty()){
            storage[bucket] = vector<int>(1000,-1);
        }
        int bucketItem = getbucketItem(key);
        if(bucketItem == buckets){
            storage[bucket].push_back(value);
        }
        else
        storage[bucket][bucketItem]= value;        
        
    }
    
    int get(int key) {
        int bucket = getbucket(key);
        if(storage[bucket].empty()){
            return -1;
        }
        int bucketItem = getbucketItem(key);
        return storage[bucket][bucketItem];
        
    }
    
    void remove(int key) {
        int bucket = getbucket(key);
        if(storage[bucket].empty()){
            return;
        }
        int bucketItem = getbucketItem(key);
        storage[bucket][bucketItem]= -1;           
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */