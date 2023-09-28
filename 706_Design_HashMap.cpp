// Time Complexity : Put O(1), Get O(1), Remove O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Got confused whethere to save K,V pair or just V


// Your code here along with comments explaining your approach
// Technique: Double Hashing
// Similar to Hashset proble, we maintain 2 arrays, one main array of size 1000, and one nested array of size 1000/1001 when required
// First hash function determintes the position in main array and second hash function determines position in nexted array.
// We maintain the Value at every position where key exists otherwise -1

#include<bits/stdc++.h>
using namespace std;

class MyHashMap {
public:
    vector<vector<int>> hset;

    MyHashMap() {
        hset = vector<vector<int>>(1000);
    }
    
    void put(int key, int value) {
        int pos1 = h1(key);
        if(hset[pos1].size() == 0) {
            if(pos1 == 0) {
                hset[pos1] = vector<int>(1001, -1);
            }
            else {
                hset[pos1] = vector<int>(1000, -1);
            }
        }

        int pos2 = h2(key);
        hset[pos1][pos2] = value;
    }
    
    int get(int key) {
        int pos1 = h1(key);
        int pos2 = h2(key);

        if(hset[pos1].size() == 0) {
            return -1;
        }
        return hset[pos1][pos2];
    }
    
    void remove(int key) {
        int pos1 = h1(key);
        int pos2 = h2(key);
        if(get(key) == -1) {
            return;
        }
        hset[pos1][pos2] = -1;
    }

private:
    int h1(int x) {
        return x%1000;
    }

    int h2(int x) {
        return x/1000;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
