// Time Complexity : O(1) all of the operation using double hash func
// Space Complexity :0(n) worst case scenario
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : missing semi-colons


//leetcode(706): https://leetcode.com/problems/design-hashmap
//Approach: This solution uses two hash(double hash) functions to figure out where to store each key-value pair. 
//The first hash picks a main bucket, and the second finds the exact spot inside that bucket. 
//Buckets are only created when needed, so overall ops are 0(1) and doesn’t waste space.
#include<iostream>

using namespace std;
//using the double hash approach to slove this problem
class MyHashMap {
private:
    //private variables and their declarations
    //crated a cosnt bucket varialbe: 1000 * (1000 or 1001) based on the hash calclualted 
    //for bucketlist on to store in bucket 0
    static const int bucket_size = 1000;
    vector<vector<int>> store;

public:
    MyHashMap() : store(bucket_size) {}

    //our hash fucntions
    int hash1(int key){ return key % bucket_size; }

    int hash2(int key){ return key / bucket_size; }
    
    void put(int key, int value) {
        int bucket = hash1(key);
        int bucket_list = hash2(key);

        if(store[bucket].empty()){// this mean it does not have any list so create
            int bucketlist_size = bucket == 0? 1001 : 1000;//ternary operation for key's upto 1mil 10001 is needed to store in bucket 0
            store[bucket].assign(bucketlist_size, -1);
        }

        //add the element or put value
        store[bucket][bucket_list] = value;

    }
    
    int get(int key) {
        int bucket = hash1(key);
        if(store[bucket].empty()) return -1;
        
        int bucket_list = hash2(key);

        return store[bucket][bucket_list];
    }
    
    void remove(int key) {
        int bucket = hash1(key);
        if(store[bucket].empty()) return;
        
        int bucket_list = hash2(key);
        store[bucket][bucket_list] = -1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
